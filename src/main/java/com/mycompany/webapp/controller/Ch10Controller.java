package com.mycompany.webapp.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.exception.Ch10SoldOutException;

@Controller
@RequestMapping("/ch10")
public class Ch10Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);
	
	@RequestMapping("/content")
	public String content(String data) {
		logger.info("실행");
		
		return "ch10/content";
	}
	
	@RequestMapping("/handlingException1")
	public String handlingException1(String data) {//try-catch로 예외처리
		logger.info("실행");
		//강제적 예외 발생
		try {
			if(data.equals("java")) {
				//NullPointerException//매개변수가 안들어올 경우//에러 발생시 사용자에게 친절하게 알려주는 형태가 되어야한다.
			}
		}catch(Exception e) {
			return "error/500_null";
		}
		
		return "redirect:/ch10/content";
	}
	
	@RequestMapping("/handlingException2")
	public String handlingException2(String data) {//그냥 예외가 발생하도록 놔둔 뒤 ExceptionHandler로 처리 처리
		logger.info("실행");
		//강제적 예외 발생
		if(data.equals("java")) {
		//NullPointerException//매개변수가 안들어올 경우//에러 발생시 사용자에게 친절하게 알려주는 형태가 되어야한다.
		}
		
		return "redirect:/ch10/content";
	}
	
	@RequestMapping("/handlingException3")
	public String handlingException3() {//그냥 예외가 발생하도록 놔둔 뒤 ExceptionHandler로 처리 처리
		//try-catch로 잡히지 않는 error -> RuntimeError
		logger.info("실행");
		Object data = "abc";
		Date date = (Date) data;//형변환 잘못해서 ClassCastException 발생
		
		return "redirect:/ch10/content";
	}
	
	@RequestMapping("/handlingException4")
	public String handlingException4() {//그냥 예외가 발생하도록 놔둔 뒤 ExceptionHandler로 처리 처리
		//try-catch로 잡히지 않는 error -> RuntimeError
		logger.info("실행");
		int[] arr = {10, 20, 30};
		arr[3] = 40;//ArrayIndexOutOfBoundsException
		
		
		return "redirect:/ch10/content";
	}
	
	@RequestMapping("/handlingException5")
	public String handlingException5(){//그냥 예외가 발생하도록 놔둔 뒤 ExceptionHandler로 처리 처리
		//try-catch로 잡히지 않는 error -> RuntimeError
		logger.info("실행");
		int stock = 0;
		if(stock == 0) {
			throw new Ch10SoldOutException("상품 재고가 없습니다.");//error 발생// try-catch, throws 안쓰려면 RuntimeException로 만들라
		}
		
		
		return "redirect:/ch10/content";
	}
	
}
