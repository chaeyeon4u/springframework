package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ch02")///ch02에서 request가 오면 실행
public class Ch02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch02Controller.class);

	@RequestMapping(value="/content")//값 하나면 value생략가능
	public String content() {
		logger.info("/ch01/content 실행");
		return "ch02/content";//이 view(jsp)를 실행해서 보여준다.
	}
	
	//@GetMapping("/method")//방법1(요청방식이 Get이고, 경로가 /content/method)
	@RequestMapping(value="/method", method=RequestMethod.GET)//방법2
	public String method1() {
		logger.info("/ch01/method1 실행");
		return "redirect:/ch02/content";//redirect 재요청 -> content() 재실행
	}
	
	//@PostMapping("/method")
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public String method2() {
		logger.info("/ch01/method2 실행");
		return "redirect:/ch02/content";
	}
	
	//@PutMapping("/method")
	@RequestMapping(value="/method", method=RequestMethod.PUT)
	public String method3() {
		logger.info("/ch01/method3 실행");
		return "redirect:/ch02/content";
	}
	
	//@DeleteMapping("/method")
	@RequestMapping(value="/method", method=RequestMethod.DELETE)
	public String method4() {
		logger.info("/ch01/method4 실행");
		return "redirect:/ch02/content";
	}
	
	@GetMapping("/modelandview")//경로는 다 소문자로..
	public ModelAndView method5(){//return형태가 String이 아닌 ModelAndView
		logger.info("ModelAndView");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ch02/modelandview");
		return modelAndView;
	}
	
	@PostMapping("/login1")
	public String login1(){
		logger.info("실행");
		return "ch02/loginResult";
	}
	
	@PostMapping("/login2")
	public String login2(){
		logger.info("실행");
		return "redirect:/ch01/content";/*redirect : 뒤 경로로 재요청하라*/
	}
	
	@GetMapping("/boardlist")
	public String boardList() {
		logger.info("실행");
		return "ch02/boardList";//jsp는 대소문자를 가린다
	}
	
	@GetMapping("/boardwriteform")
	public String boardWriteForm() {
		
		return "ch02/boardWriteForm";
	}
	
	@PostMapping("/boardwrite")
	public String boardWrite() {
		//return "ch02/boardList";//url과 내용이 일치하지 않는다. 게시물 여러번 저장할 수 있다 절대 x
		return "redirect:/ch02/boardlist";
	}
}

