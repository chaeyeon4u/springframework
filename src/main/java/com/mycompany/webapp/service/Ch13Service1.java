package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.webapp.controller.Ch01Controller;
import com.mycompany.webapp.dao.Ch13BoardDao1;


public class Ch13Service1 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service1.class);
	
	//private Ch13BoardDao1 ch13BoardDao1;//nullpointexception 원인 -> 의존성 주입 일어나야함//service에서 dao 사용
	//1. setter, 2.생성자를 이용한 주입! ,3. 필드로 직접 넣기(bean으로 넣기:setter, 생성자를 이용한 주입 )
	//@Anotation: setter, 생성자를 이용한 주입, 필드로 직접 넣기
	private Ch13BoardDao1 ch13BoardDao1;
	
	
	public Ch13Service1() {
		logger.info("실행");
	}
	
	//생성자 주입을 위한 생성자 선언//nullpointexception 안일어남
	public Ch13Service1(Ch13BoardDao1 ch13BoardDao1) {
		logger.info("Ch13Service1 (Ch13BoardDao1 ch13BoardDao1) 실행");
		this.ch13BoardDao1 = ch13BoardDao1;
	}
	
	//주입을 위한 Setter 선언
	public void setCh13BoardDao1(Ch13BoardDao1 ch13BoardDao1) {//xml에서 setter의 이름 : ch13BoardDao1
		logger.info("실행");
		this.ch13BoardDao1 = ch13BoardDao1;
	}
	
	
	public void method1() {//NullPointException
		logger.info("실행");

		ch13BoardDao1.update();
	}
}
