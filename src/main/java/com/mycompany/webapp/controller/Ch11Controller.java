package com.mycompany.webapp.controller;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch11Member;


@Controller
@RequestMapping("/ch11")
public class Ch11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);
	
	@RequestMapping("/content")
	public String content(String data) {
		logger.info("실행");
		
		return "ch11/content";
	}
	
	@GetMapping("/form1")
	public String form1(@ModelAttribute("member") Ch11Member member) {//Dto를 매개변수로 사용하면 자동으로 소문자로한 이름으로 관리된다.
		logger.info("실행");
		/*String defaultNation = "한국";//값을 사용하게 하기위해 model 사용해서 form1.jsp에 전달해서 사용
		model.addAttribute("defaultNation", defaultNation);*/
		member.setMnation("한국");
		
		return "ch11/form1";
	}
	
	//form의 데이터를 받을 목적
	@PostMapping("/form1")
	public String handleForm1(@ModelAttribute("member") Ch11Member member) {
		logger.info("mid: "+member.getMid());
		logger.info("mname :"+member.getMname());
		logger.info("mpassword : "+member.getMpassword());
		logger.info("mnation: "+member.getMnation());
		
		return "redirect:/ch11/content";
	}
	
	@GetMapping("/form2")
	   public String form2(@ModelAttribute("member") Ch11Member member, Model model) {
	      logger.info("실행");
	      
	      // 드롭다운리스트의 항목을 추가할 목적
	      List<String> typeList = new ArrayList<>();
	      typeList.add("일반회원");
	      typeList.add("기업회원");
	      typeList.add("헤드헌터회원");
	      model.addAttribute("typeList", typeList);
	      
	      // 기본 선택 항목을 설정
	      member.setMtype("기업회원");
	      
	      return "ch11/form2";
	   }

	/*@GetMapping("/form2")
	public String form2(@ModelAttribute("member") Ch11Member member, Model model) {//Dto를 매개변수로 사용하면 자동으로 소문자로한 이름으로 관리된다.
		logger.info("실행");
		
		//드롭다운리스트의 항목을 추가할 목적
		List<String> typeList = new ArrayList();
		typeList.add("일반회원");
		typeList.add("기업회원");
		typeList.add("헤드헌터회원");
		model.addAttribute("typeList", typeList);
		
		//기본 선택 항목을 설정
		member.setMtype("기업회원");
		
		return "ch11/form2";
	}*/
	
}
