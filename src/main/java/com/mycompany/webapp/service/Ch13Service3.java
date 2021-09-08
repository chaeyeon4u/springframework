package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("service3")//name 지정해준 경우.
public class Ch13Service3 implements Ch13Service{
	private static Logger logger = LoggerFactory.getLogger(Ch13Service3.class);
	
	@Override
	public void method2() {
		logger.info("실행");
		
	}
	
}
