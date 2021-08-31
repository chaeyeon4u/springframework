package com.mycompany.webapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.LoggerFactory;

import com.mycompany.webapp.dto.Ch04Member;
import com.mycompany.webapp.validator.Ch04MemberEmailValidator;
import com.mycompany.webapp.validator.Ch04MemberIdValidator;
import com.mycompany.webapp.validator.Ch04MemberJoinFormValidator;
import com.mycompany.webapp.validator.Ch04MemberPasswordValidator;
import com.mycompany.webapp.validator.Ch04MemberTelValidator;

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
		//return "ch04/content";
		return "redirect:/ch04/content";
	}
	
	@InitBinder("joinForm")
	public void joinFormSetValidator(WebDataBinder binder) {
		logger.info("실행");
		//binder.setValidator(new Ch04MemberJoinFormValidator());
		
		binder.addValidators(
			new Ch04MemberIdValidator(),
			new Ch04MemberPasswordValidator(),
			new Ch04MemberEmailValidator(),
			new Ch04MemberTelValidator()
		);//자바에서 ...은 가변길이 매개변수라는 뜻
	}
	
	//@ModelAttribute 없을 경우 : Ch04Member -> ch04Member라는 이름으로 관리함 (@InitBinder) //첫자 소문자
	//@ModelAttribute 있을 경우 : joinForm 이라는 이름으로 관리함
	@PostMapping("/method2")
	public String join(@ModelAttribute("joinForm") @Valid Ch04Member member, BindingResult bindingResult) {//BindingResult bindingResult -> Errors errors 대체 가능
		logger.info("실행");
		if(bindingResult.hasErrors()) {
			logger.info("다시 입력폼 제공 + Erro 메시지");
			return "ch04/content";
		}else {
			logger.info("정상 요청 처리후 응답 제공");
			return "redirect:/";
		}
		
	}
	
	@InitBinder("loginForm")
	public void loginFormSetValidator(WebDataBinder binder) {
		logger.info("실행");
		
		binder.addValidators(
			new Ch04MemberIdValidator(),
			new Ch04MemberPasswordValidator()
		);
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") @Valid Ch04Member member, Errors errors) {
		logger.info("실행");
		if(errors.hasErrors()) {
			logger.info("다시 입력폼 제공 + Erro 메시지");
			return "ch04/content";//foreward로 이동 : 기존의 데이터 사용 가능
		}else {
			logger.info("정상 요청 처리후 응답 제공");
			
			return "redirect:/";//redirect로 이동
		}
	}
	
}
