package com.mycompany.webapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Ch15Aspect4AfterReturning {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Aspect4AfterReturning.class);

	//정상적으로 return을 했을 때
	@AfterReturning(
		pointcut = "execution(public * com.mycompany.webapp.controller.Ch15Controller.afterReturning*(..))",
		returning="returnValue"
	)
	public void method(String returnValue) {
		logger.info("실행");
		logger.info("리턴값 : " + returnValue);
	}
}
