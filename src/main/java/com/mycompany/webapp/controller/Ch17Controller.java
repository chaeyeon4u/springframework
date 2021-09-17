package com.mycompany.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.service.Ch14MemberService;
import com.mycompany.webapp.service.Ch14MemberService.joinResult;

@Controller
@RequestMapping("/ch17")
public class Ch17Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch17Controller.class);

	@RequestMapping("/content")
	public String content() {
		logger.info("실행");

		return "ch17/content";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "ch17/loginForm";
	}
	
	@RequestMapping("/adminAction")
	public String adminAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/managerAction")
	public String managerAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/userAction")
	public String userAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/error403")
	public String error403() {
		logger.info("실행");
		return "ch17/error403";
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		logger.info("실행");
		return "ch17/joinForm";
	}
	
	@Resource
	private Ch14MemberService memberService;
	
	@RequestMapping("/join")
	public String join(Ch14Member member, Model model) {
		logger.info("실행");
		
		//활성화 설정
		member.setMenabled(1);// 활성화
		
		//password 암호화
		String mpassword = member.getMpassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//암호화 위한 bcrypt 객체 생성
		mpassword = "{bcrypt}"  + passwordEncoder.encode(mpassword);//암호화 적용
		member.setMpassword(mpassword);

		// 회원 가입 처리
		joinResult jr = memberService.join(member);
		if (jr == joinResult.SUCCESS) {
			return "redirect:/ch17/loginForm";
		} else if (jr == joinResult.DUPLICATED) {
			model.addAttribute("error", "중복된 아이디가 있습니다.");
			return "ch17/joinForm";
		} else {
			model.addAttribute("error", "회원 가입이 실패되었습니다. 다시 시도해 주세요.");
			return "ch17/joinForm";
		}
	}
	
	@RequestMapping(value="/userInfo", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String userInfo(Authentication authentication) {
		logger.info("실행");
		
		/*Authentication 얻기 1 -> 매개변수로 받기 가능
		//Spring Security가 인증 정보를 저장하는 컨테이너 얻기
		//Holder 뭐를 가지고있는 아이
		//SecurityContext securityContext = SecurityContextHolder.getContext();
		
		//인증 정보 객체를 얻기
		//Authentication authentication = securityContext.getAuthentication();
		 
		 */
		
		//사용자 식별값(아이디) 얻기
		String mid = authentication.getName();//아이디가 될수도 있고, 이메일이 될수도 있는데 여기서는 아이디
		
		
		//GrantedAuthority에 대한 Collection 리턴
		//권한이 여러개일 수 있어 하는 처리
		//사용자 권한(role) 얻기
		List<String> authorityList = new ArrayList();
		for(GrantedAuthority authority : authentication.getAuthorities()) {
			authorityList.add(authority.getAuthority());//role 이름이 넘어간다
		}
		
		//사용자가 로그인한 PC의 IP 주소 얻기
		WebAuthenticationDetails wad = (WebAuthenticationDetails) authentication.getDetails();//상세정보 얻기
		String ip = wad.getRemoteAddress();
		
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("mid", mid);
		jsonObject.put("mrole", authorityList);
		jsonObject.put("ip", ip);
		
		String json = jsonObject.toString();
		return json;
	}
	
	
}
