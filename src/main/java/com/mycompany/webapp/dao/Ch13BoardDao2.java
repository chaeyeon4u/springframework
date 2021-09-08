package com.mycompany.webapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.service.Ch13Service2;

@Repository//관리 객체 만들어줌-> beanTag 안만들어줘도 된다.
public class Ch13BoardDao2 {
private static final Logger logger = LoggerFactory.getLogger(Ch13Service2.class);
	
	public Ch13BoardDao2() {
		logger.info("실행");
	}
	
	public void update() {
		logger.info("실행");
	}
}
