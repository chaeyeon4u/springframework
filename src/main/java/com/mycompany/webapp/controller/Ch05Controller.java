package com.mycompany.webapp.controller;

import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping("ch05")
public class Ch05Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch05Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		
		return "ch05/content";
	}
	
	@GetMapping("/getHeaderValue")
	public String getHeaderValue(HttpServletRequest request) {
		logger.info("실행");
		
		logger.info("requestURI : " + request.getRequestURI());
		logger.info("method : "+ request.getRequestURI());
		logger.info("client IP : "+ request.getRemoteAddr()); //ip주소
		logger.info("contextRoot : " + request.getContextPath());
		String userAgent = request.getHeader("User-Agent");//OS, Browser 정보 포함
		
		logger.info(userAgent);//브라우저마다 다르게 띄워진다.
		
		if(userAgent.contains("Windows NT")) {
			logger.info("client OS: Windows");
		}else if(userAgent.contains("Macintosh")) {
			logger.info("client OS: macOS");
		}
		
		if(userAgent.contains("Edg")) {
			logger.info("client Browser: Edge");
		}else if(userAgent.contains("Trident")) {
			logger.info("client Browser: IE11");
		}else if(userAgent.contains("Chrome")) {
			logger.info("client Browser: Chrome");
		}else if(userAgent.contains("Safari")) {
			logger.info("client Browser: Safari");
		}
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		logger.info("실행");
		
		Cookie cookie = new Cookie("useremail", "blueskii@naver.com");//쿠키 객체 생성, 쿠키의 값은 문자열만 저장가능
		cookie.setDomain("localhost");//localhost면 전송
		cookie.setPath("/");		//path 설정, "/ch05"이면 ch05로 요청시에만 들고가라
		cookie.setMaxAge(30*60);	//setMaxAge의 단위는 초단위, 30*60: 30분, 30분 뒤 사라짐//이 시간동안만 전송
		cookie.setHttpOnly(true);	//JavaScript에서 못 읽게함
		cookie.setSecure(true);		//https://만 전송
		
		//번호표를 준다.-> response를 추가
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";
	}
	
	//getCookie1 써라 쉽다.
	@GetMapping("/getCookie1")
	public String getCookie1(@CookieValue("useremail") String uemail, 
							@CookieValue String useremail) {//쿠키값(useremail)을 uemail에 넣어준다. 같으면 ("useremail") 없어도됨
		logger.info("실행");
		
		logger.info("useremail: " + uemail);
		logger.info("useremail: " + useremail);

		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/getCookie2")
	public String getCookie2(HttpServletRequest request) {
		logger.info("실행");
		
		Cookie[] cookies = request.getCookies();//배열로 리턴
		for(Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			if(cookieName.equals("useremail")) {
				logger.info("useremail: "+cookieValue);
				
				break;
			}
		}
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/createJsonCookie")
	public String createJsonCookie(HttpServletResponse response) throws Exception {
		logger.info("createJsonCookie 실행");
		
		//json 방법1
		//String json = "{\"userid\":\"fall\", \"useremail\":\"fall@company.com\", \"username\":\"홍길동\"}";
		
		//json 방법2 (선호)
		JSONObject jsonObject = new JSONObject();//json objec : {} , json array: []
		jsonObject.put("userid", "fall");
		jsonObject.put("useremail", "fall@company.com");
		jsonObject.put("username", "홍길동");
		String json = jsonObject.toString();
		
		logger.info("json : "+ json);
		json = URLEncoder.encode(json, "UTF-8");//"큰 따옴표를 넣을 수 없어서 encoding
		logger.info("json : "+ json);
		
		Cookie cookie = new Cookie("user", json);//한글 사용 불가
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/getJsonCookie")
	public String getJsonCookie(@CookieValue String user) {
		logger.info("실행");
		logger.info("user : "+user);
		JSONObject jsonObject = new JSONObject(user);//괄호 데이터 존재 : 해석, 괄호 데이터 없음 : 생성, {}:Object
		
		String userid = "userid : "+ jsonObject.getString("userid");
		String useremail = "useremail : "+ jsonObject.getString("useremail");
		String username = "username : "+ jsonObject.getString("username");
		
		logger.info("userid : "+ userid);
		logger.info("useremail : "+ useremail);
		logger.info("username : "+ username);
		
		return "redirect:/ch05/content";
	}
	
	//암호화하여 보내
	//암호화 하기위한 방법 JSON Web Token(JWT)
	@GetMapping("/createJwtCookie")
	public String createJwtCokie(HttpServletResponse response) throws Exception {
		logger.info("실행");
		
		String userid = "fall";
		String useremail = "fall@company.com";
		String username = "홍길동";
		
		JwtBuilder builder = Jwts.builder();//jws 만든다..
		/*head*/
		builder.setHeaderParam("alg", "HS256");//header 추가
		builder.setHeaderParam("typ", "JWT");
		//1000 : 1초, 1000*60*30: 30분
		builder.setExpiration(new Date(new Date().getTime() + 1000*60*30));//유효기간 설정 //new Date().getTime() : 1970년 자정을 0으로 해서 1/1000초 단위로 카운팅 한 수
		/*head*/
		//clain : 데이터 하나를 의미 -> 여러개 : payload
		builder.claim("userid", userid);
		builder.claim("useremail", useremail);
		builder.claim("username", username);
		/*Signature*/
		String secreteKey = "abc12345";//키값 모르면 복원 불가.
		builder.signWith(SignatureAlgorithm.HS256, secreteKey.getBytes("UTF-8"));//암호화 알고리즘 추가
		String jwt = builder.compact();
		
		logger.info("jwt: "+jwt);
		
		Cookie cookie = new Cookie("jwt", jwt);//암호화된 키 cookie에 넣음
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/getJwtCookie")
	public String getJwtCokie(@CookieValue String jwt) throws Exception {
		logger.info("실행");
		
		logger.info(jwt);
		
		//키 해석
		JwtParser parser = Jwts.parser();//암호문 -> 평문 위한 파서
		String secreteKey = "abc12345";//비밀키
		parser.setSigningKey(secreteKey.getBytes("UTF-8"));//바이트단위로 넣는다.
		Jws<Claims> jws = parser.parseClaimsJws(jwt);
		Claims claims = jws.getBody();
		String userid = claims.get("userid", String.class);//id: userid ,type:String으로 가져온다.
		String useremail = claims.get("useremail", String.class);
		String username = claims.get("username", String.class);
		
		logger.info("userid : "+ userid);
		logger.info("useremail : "+ useremail);
		logger.info("username : "+ username);
		
		return "redirect:/ch05/content";
	}
	
}
