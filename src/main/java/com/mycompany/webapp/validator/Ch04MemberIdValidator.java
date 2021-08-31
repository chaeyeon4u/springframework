package com.mycompany.webapp.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;

public class Ch04MemberIdValidator implements Validator{

	private static final Logger logger = LoggerFactory.getLogger(Ch04MemberIdValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("실행");
		boolean check = Ch04Member.class.isAssignableFrom(clazz);
		
		return check;
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("실행");
		
		Ch04Member member = (Ch04Member) target;//강제 타입 변환
		//mid 검사
		if(member.getMid() == null || member.getMid().trim().equals("")) {
			//문제 등록(mid : dto의 변수와 일치해야한다. && errors.mid.required : ch04_error.properties의 속성값)
			errors.rejectValue("mid", "errors.mid.required");
		}else {
			//길이 조사
			if(member.getMid().length() < 4) {
				errors.rejectValue("mid", "errors.mid.minlength", new Object[] {4}, "");//new Object[] {4} : error 메시지의 값으로 들어간다.
			}
		}
	}

	
}
