package com.mycompany.webapp.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.service.Ch13Service;
import com.mycompany.webapp.service.Ch13Service1;
import com.mycompany.webapp.service.Ch13Service2;
import com.mycompany.webapp.service.Ch13Service3;

@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Controller.class);

	private Ch13Service1 ch13Service1;//객체 없으면 nullpointException-> 의존성 주입 일어나야함
	
	//@Autowired
	@Resource//첫자를 소문자로한 이름으로 관리
	private Ch13Service2 ch13Service2;
	
	//이름을 객체찾아 주입
	//ch13Service인터페이스를 상속받는 클래스가 2개이므로 name을 준다.
	@Resource(name="ch13Service4")
	private Ch13Service ch13Service;
	
	/* @Controller 선언-> 직접 만들어짐 -> 다른 생성자 못만듦-> 오로지 setter 주입만 만듦
	 * public Ch13Controller() {
		logger.info("실행");
	}*/
	
	
	public Ch13Controller() {
		logger.info("실행");
	}
	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");

		return "ch13/content";
	}
	
	//@Autowired 
	@Resource
	public void setCh13Service2(Ch13Service2 ch13Service2) {
		logger.info("실행");
		this.ch13Service2 = ch13Service2;
	}

	@GetMapping("/request1")
	public String request1() {
		logger.info("실행");
		ch13Service1.method1();//controller에서 service사용 
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/request2")
	public String request2() {
		logger.info("실행");
		ch13Service2.method1();//controller에서 service사용 
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/request3")
	public String request3() {
		logger.info("실행");
		//ch13Service.method1();//controller에서 service사용 
		ch13Service.method2();
		return "redirect:/ch13/content";
	}
	
	//주입을 위한 setter 선언
	public void setCh13Service1(Ch13Service1 ch13Service1) {
		logger.info("setter 실행");
		this.ch13Service1 = ch13Service1;
	}

	

}
