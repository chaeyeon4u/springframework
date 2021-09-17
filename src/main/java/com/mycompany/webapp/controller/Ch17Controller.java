package com.mycompany.webapp.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.service.Ch14MemberService;
import com.mycompany.webapp.service.Ch14MemberService.joinResult;

@Controller
@RequestMapping("/ch17")
public class Ch17Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch17Controller.class);

	@RequestMapping("/content")
	public String content() {
		logger.info("실행");

		return "ch17/content";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "ch17/loginForm";
	}
	
	@RequestMapping("/adminAction")
	public String adminAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/managerAction")
	public String managerAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/userAction")
	public String userAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/error403")
	public String error403() {
		logger.info("실행");
		return "ch17/error403";
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		logger.info("실행");
		return "ch17/joinForm";
	}
	
	@Resource
	private Ch14MemberService memberService;
	
	@RequestMapping("/join")
	public String join(Ch14Member member, Model model) {
		logger.info("실행");
		
		//활성화 설정
		member.setMenabled(1);// 활성화
		
		//password 암호화
		String mpassword = member.getMpassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//암호화 위한 bcrypt 객체 생성
		mpassword = "{bcrypt}"  + passwordEncoder.encode(mpassword);//암호화 적용
		member.setMpassword(mpassword);

		// 회원 가입 처리
		joinResult jr = memberService.join(member);
		if (jr == joinResult.SUCCESS) {
			return "redirect:/ch17/loginForm";
		} else if (jr == joinResult.DUPLICATED) {
			model.addAttribute("error", "중복된 아이디가 있습니다.");
			return "ch17/joinForm";
		} else {
			model.addAttribute("error", "회원 가입이 실패되었습니다. 다시 시도해 주세요.");
			return "ch17/joinForm";
		}
	}
	
	
}
