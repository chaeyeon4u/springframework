package com.mycompany.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Anotation 필수적! Controller는 요청을 제어한다.
@Controller
@RequestMapping("/ch01")
public class Ch01Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch01Controller.class);

	//Browser가 "http://localhost:8080/contextRoot/"를 요청하면 실행 => 생략해서 "/"(Browser -> controller)
	@RequestMapping("/content")
	public String content() {
		logger.debug("실행1");

		//리턴값의 의미 => view의 파일명이 리턴된다!(controller -> view(.jsp)
		return "ch01/content";
	}
}
//
