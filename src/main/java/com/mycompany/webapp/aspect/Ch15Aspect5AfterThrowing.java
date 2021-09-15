package com.mycompany.webapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Ch15Aspect5AfterThrowing {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Aspect5AfterThrowing.class);

	//정상적으로 return을 했을 때
	@AfterThrowing(
		pointcut = "execution(public * com.mycompany.webapp.controller.Ch15Controller.afterReturning*(..))",
		throwing="e"
	)
	
	public void method(Throwable e) {
		logger.info("실행");
		logger.info("리턴값 : " + e.getMessage());
	}
}
