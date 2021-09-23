package com.mycompany.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.webapp.dto.Ch07Board;
import com.mycompany.webapp.dto.Ch07City;
import com.mycompany.webapp.dto.Ch07Cloth;
import com.mycompany.webapp.dto.Ch07Member;

@Controller
@RequestMapping("/ch07")
public class Ch07Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch07Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch07/content";
	}
	
	@GetMapping("/saveData")
	public String saveData(HttpServletRequest request) {
		logger.info("실행");
		
		//Request 범위에 데이터를 저장(저장이름, 저장데이터)
		request.setAttribute("requestData", "자바");
		
		//Session범위에 데이터를 저장(저장이름, 저장데이터)//브라우저 범위에 저장
		HttpSession session = request.getSession();
		session.setAttribute("sessionData", "자바스크립트");
		
		//Application 범위에 데이터를 저장(저장이름, 저장데이터)//어플 전체에 대한 부분
		ServletContext application = request.getServletContext();
		application.setAttribute("applicationData", "백앤드");
		return "ch07/readData";
	}
	
	@GetMapping("/readData")
	public String readData() {
		logger.info("실행");
		return "ch07/readData";
	}
	
	@GetMapping("/objectSaveAndRead1")
	public String objectSaveAndRead1(HttpServletRequest request) {
		logger.info("실행");
		
		Ch07Member member = new Ch07Member();
		member.setName("홍길동");
		member.setAge(23);
		member.setJob("프로그래머");
		Ch07City city = new Ch07City();
		city.setName("서울");
		member.setCity(city);
		
		request.setAttribute("member", member);//객체 저장 가능
		
		return "ch07/objectRead";
	}
	
	@GetMapping("/objectSaveAndRead2")
	public ModelAndView objectSaveAndRead2(HttpServletRequest request) {
		logger.info("실행");
		
		Ch07Member member = new Ch07Member();
		member.setName("홍길동");
		member.setAge(23);
		member.setJob("프로그래머");
		Ch07City city = new Ch07City();
		city.setName("서울");
		member.setCity(city);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("ch07/objectRead");
		
		return mav;
	}
	
	@GetMapping("/objectSaveAndRead3")
	public String objectSaveAndRead3(Model model) {
		logger.info("실행");
		
		Ch07Member member = new Ch07Member();
		member.setName("홍길동");
		member.setAge(23);
		member.setJob("프로그래머");
		Ch07City city = new Ch07City();
		city.setName("서울");
		member.setCity(city);
		
		model.addAttribute("member", member);
		
		return "ch07/objectRead";
	}
		
	@GetMapping("/useJstl1")
	public String useJstl(Model model) {
		logger.info("실행");
		
		String[] languages = {"Java", "Javascript", "Springframework"};
		model.addAttribute("languages", languages);
		
		return "ch07/useJstl1";
	}
	
	@GetMapping("/useJstl2")
	public String useJst2(Model model) {
		logger.info("실행");
		
		List<Ch07Board> list = new ArrayList(); 
		for(int i=1; i<=5; i++) {
			list.add(new Ch07Board(i, "제목"+i, "내용"+i, "글쓴이"+i, new Date()));
		}
		
		model.addAttribute("boardList", list);
		
		return "ch07/useJstl2";
	}
	
	//공통 Attribute -> useModelAttribute1, useModelAttribute2 에서 사용 가능
	//어떤 범위에 저장할까? : 요청이 달라도 쓸 수 있다 -> 하지만 request 범위
	//요청 할 때마다 실행된다..!
	@ModelAttribute("colors")//이름
	public String[] getColors() {
		logger.info("실행");
		String[] colors = {"Red", "Green", "Blue", "Yellow", "Pink"};
		return colors;//값
	}
	
	@GetMapping("/useModelAttribute1")
	public String useModelAttribute1(Model model) {//실행 횟수보려고 만든거 404 오류남
		logger.info("실행");
		
		return "ch07/useModelAttribute";
	}
	
	@GetMapping("/useModelAttribute2")
	public String useModelAttribute2(Model model){
		logger.info("실행");
		
		return "ch07/useModelAttribute";
	}
	
	//@ModelAttribute String -> kind를 이름으로하고 값으로하는 변수생성해서 반환
	@GetMapping("/argumentSaveAndRead1")
	public String argumentSaveAndRead1(@ModelAttribute("kind") String kind, @ModelAttribute("sex") String sex/*, Model model*/) {
		logger.info("실행");
		
//		model.addAttribute("kind", kind);
//		model.addAttribute("sex", sex);
		
		return "ch07/argumentReader1";
	}
	
	@GetMapping("/argumentSaveAndRead2")
	public String argumentSaveAndRead2(@ModelAttribute("cloth") Ch07Cloth cloth) {//ch07Cloth(첫자를 소문자) 라는 이름으로 관리된다.. argumentReader2에서 사용
		logger.info("실행");
		
		logger.info("kind: "+cloth.getKind());
		logger.info("sex: "+cloth.getSex());
		
		return "ch07/argumentReader2";
	}
	
}
