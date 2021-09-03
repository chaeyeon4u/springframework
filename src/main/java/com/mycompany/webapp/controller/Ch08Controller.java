package com.mycompany.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch08/content";
	}
	
	@GetMapping(value="/saveData", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String savaData(String name, HttpSession session) {//HttpSession 브라우저가 session 바로 넣어준다.
		logger.info("실행");
		logger.info("name",name);
		
		session.setAttribute("name", name);
		
		//ajax로 요청한다 가정
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString();//{"result":"success"}
		
		return json;//뷰이름을 리턴하는게 아니라
	}
	
	/*@GetMapping(value="/readData", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String readData(HttpSession session) {//HttpSession 브라우저가 session 바로 넣어준다.
		logger.info("실행");
		
		//How1
		String name = (String) session.getAttribute("name");
		logger.info(name);
		
		//ajax로 요청한다 가정
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name : ", name);
		String json = jsonObject.toString();//{"result":"success"}
		
		return json;//뷰이름을 리턴하는게 아니라
	}*/
	
	@GetMapping(value="/readData", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String readData(HttpSession session, @SessionAttribute("name") String name) {//HttpSession 브라우저가 session 바로 넣어준다.
		logger.info("실행");
		
		//How2
		logger.info(name);
		
		//ajax로 요청한다 가정
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name : ", name);
		String json = jsonObject.toString();//{"result":"success"}
		
		return json;//뷰이름을 리턴하는게 아니라
	}
}
