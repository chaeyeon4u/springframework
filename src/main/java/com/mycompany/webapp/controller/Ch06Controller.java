package com.mycompany.webapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller를 붙이면, 어플리케이션 실행시 Ch06Controller 객체가 생성된다
@Controller
@RequestMapping("ch06")
public class Ch06Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
	
//	public Ch06Controller() {//제일 먼저 만들어진다는거 확인
//		logger.info("실행");
//	}
	
	@RequestMapping("/content")
	public String content(){
		return "ch06/content";
	}
	
	@RequestMapping("/forward")
	public String forward() {
		return "ch06/forward";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:/";
	}
	
	@GetMapping("/getFragmentHtml")
	public String getFragmentHtml() {
		return "ch06/fragment";
	}
	
	//json으로 직접 출력
	@GetMapping("/getJson1")
	public void getJson1(HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo4.jpg");
		String json = jsonObject.toString();
		
		//직접 응답 만들어냄 -> jsp로 forward 하지 않아도 됨
		//ajax는 redirect 불가능
		//응답 HTTP의 Body부분에 json을 포함
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
		pw.close();
	}
	
	//getJson1보다 2이거 잘 알고있어야 한다.
	//헤더에 application/json; charset=UTF-8 들어간다
	@GetMapping(value="/getJson2", produces="application/json; charset=UTF-8")//application/json : json//ContentType을 Setting
	@ResponseBody
	public String getJson2() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo5.jpg");
		String json = jsonObject.toString();
				
		return json;//뷰이름이 아니다! 응답바디(@ResponseBody)에 들어가는 내용이다
	}
	
	//여기 코드 맞나 체크해보기
	@GetMapping("/getJson3")
	public String getJson3() {
		logger.info("실행");
		
		return "redirect:/";
	}
}
