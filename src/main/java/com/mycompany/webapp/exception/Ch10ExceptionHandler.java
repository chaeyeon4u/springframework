package com.mycompany.webapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//SpringFramework가 예외처리를 하는걸 알려줘야한다.
@Component//이 클래스를 가지고 미리 객체를 생성해서 관리를 해라!//얘 안붙이면 생성자 실행 안함
@ControllerAdvice // 조언자의 역할로, Controller와 관계가 맺어진다. 모든 컨트롤러와 관게가 있다.
public class Ch10ExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(Ch10ExceptionHandler.class);
	
	public Ch10ExceptionHandler() {
		logger.info("실행");
	}
	
	//어떤 예외인지에 따라 영향을 달리하겠다.
	//예외 처리자 설정
	//NullPointerException 발생시 처리
	@ExceptionHandler
	public String handleNullPointerException(NullPointerException e) {
		logger.info("실행");
		e.printStackTrace();
		return "error/500_null";
	}
	
	@ExceptionHandler
	public String handleClassCastException(ClassCastException e) {
		logger.info("실행");
		e.printStackTrace();
		return "error/500_cast";
	}
	
	
	@ExceptionHandler
	public String handleCh16NotFoundAccountException(Ch16NotFoundAccountException e, Model model) {//Exception으로 해도 괜찮음
		logger.info("실행");
		e.printStackTrace();
		model.addAttribute("error", e.getMessage());
		return "error/notFoundAccountException";
	}
	
	@ExceptionHandler
	public String handleException(Ch10SoldOutException e) {//Exception으로 해도 괜찮음
		logger.info("실행");
		e.printStackTrace();
		return "error/soldout";
	}
	
	//구체적 예외처리 이후 보통의 예외처리
	@ExceptionHandler
	public String handleException(RuntimeException e) {//Exception으로 해도 괜찮음
		logger.info("실행");
		e.printStackTrace();
		return "error/500";
	}
		
}
