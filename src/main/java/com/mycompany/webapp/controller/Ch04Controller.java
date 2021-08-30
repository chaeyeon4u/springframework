package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.LoggerFactory;

import com.mycompany.webapp.dto.Ch04Member;

@Controller
@RequestMapping("ch04")
public class Ch04Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch04Controller.class);

	@RequestMapping("/content")
	public String ch04Controller() {
		
		return "ch04/content";
	}
	
	@PostMapping("/method1")
	public String method1() {
		return "redirect:/ch04/content";
	}
	
	@PostMapping("/method2")
	public String method2(Ch04Member member) {
		logger.info("mid : "+ member.getMid());
		logger.info("getMpassword : "+ member.getMpassword());
		logger.info("getMemail : "+ member.getMemail());
		logger.info("getMtel : "+ member.getMtel());
		
		return "redirect:/ch04/content";
	}
}
