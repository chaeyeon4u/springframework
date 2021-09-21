package com.mycompany.webapp.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.webapp.dto.Ch03Dto;

@Controller
@RequestMapping("/ch03")
public class Ch03Controller {
	private static Logger logger = LoggerFactory.getLogger(Ch03Controller.class);

	@RequestMapping("/content")
	public String content() {
		return "ch03/content";
	}

	//ctrl+shift+/ -> 주석 \->주석 해제
	/*@GetMapping("/method1")
	public String method1(//똑같은 매개변수명으로 받아야한다.
			@RequestParam("param1") String p1,//또다른 사용
			String param2,
			String param3,
			String param4,
			String param5
	){
		logger.info("param1 : "+ p1);
		logger.info("param2 : "+ param2);
		logger.info("param3 : "+ param3);
		logger.info("param4 : "+ param4);
		logger.info("param5 : "+ param5);
		logger.info("실행");
		return "redirect:/ch03/content";
	}*/
	
	/*param5 -> dateType으로 받기
	 * param2 -> Int로 받기(자동 변환)
	 * param3 -> double로 받기
	 * param4 -> boolean으로 
	 * 
	 * String이 아니라면 null값에 대한 default 값 설정 : defaultValue
	 * */
	@GetMapping("/method1")
	public String method1(
			String param1,
			@RequestParam(value="param2", defaultValue = "0") int p2,//또다른 사용... 잘안써
			@RequestParam(defaultValue = "0.0") double param3,
			@RequestParam(defaultValue = "false") boolean param4,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date param5
	){
		logger.info("param1 : "+ param1);
		logger.info("param2 : "+ p2);
		logger.info("param3 : "+ param3);
		logger.info("param4 : "+ param4);
		logger.info("param5 : "+ param5);
		logger.info("실행");
		return "redirect:/ch03/content";
	}
	
	/*@GetMapping("/method1")
	public String method1(Ch03Dto dto){
		logger.info("param1 : "+ dto.getParam1());
		logger.info("param2 : "+ dto.getParam2());
		logger.info("param3 : "+ dto.getParam3());
		logger.info("param4 : "+ dto.isParam4());
		logger.info("param5 : "+ dto.getParam5());
		logger.info("실행");
		return "redirect:/ch03/content";
	}*/

	/*@PostMapping("/method2")
	public String method2(String param1, String param2, String param3, String param4, String param5) {
		logger.info("param1 : " + param1);
		logger.info("param2 : " + param2);
		logger.info("param3 : " + param3);
		logger.info("param4 : " + param4);
		logger.info("param5 : " + param5);
		logger.info("실행");
		return "redirect:/ch03/content";
	}*/
	
	/*@PostMapping("/method2")
	public String method2(
			String param1,
			@RequestParam(defaultValue = "0") int param2,
			@RequestParam(defaultValue = "0.0")double param3,
			@RequestParam(defaultValue = "false") boolean param4,
			@DateTimeFormat(pattern="yyy-MM-dd") Date param5
	) {
		logger.info("param1 : " + param1);
		logger.info("param2 : " + param2);
		logger.info("param3 : " + param3);
		logger.info("param4 : " + param4);
		logger.info("param5 : " + param5);
		logger.info("실행");
		return "redirect:/ch03/content";
	}*/
	
	@PostMapping("/method2")
	public String method2(Ch03Dto dto) {
		logger.info("param1 : "+ dto.getParam1());
		logger.info("param2 : "+ dto.getParam2());
		logger.info("param3 : "+ dto.getParam3());
		logger.info("param4 : "+ dto.isParam4());
		logger.info("param5 : "+ dto.getParam5());
		logger.info("실행");
		return "redirect:/ch03/content";
	}

	@RequestMapping("/method3")
	public String method3() {
		logger.info("실행");
		return "redirect:/ch03/content";
	}
}
