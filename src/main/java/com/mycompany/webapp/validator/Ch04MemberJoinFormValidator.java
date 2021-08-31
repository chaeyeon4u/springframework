package com.mycompany.webapp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;

public class Ch04MemberJoinFormValidator implements Validator{
	
	private static final Logger logger = LoggerFactory.getLogger(Ch04MemberJoinFormValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("실행");
		//데이터에 대한 유효성 검사 가능시 true, 불가시 false
		// clazz라는 클래스가 Ch04Member로 검증될 수 있냐? 
		// => clazz가 Ch04Member의 최소 자식 객체거나 같은 객체이냐?
		boolean check = Ch04Member.class.isAssignableFrom(clazz);
		return check;
	}

	//supports가 true 반환시 validate 실행
	//Object target -> Ch04Member.class
	//Errors errors -> 에러의 내용을 등록
	@Override
	public void validate(Object target, Errors errors) {
		logger.info("실행");
		Ch04Member member = (Ch04Member) target;
		
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
		
		//mpassword 검사
		if(member.getMpassword() == null || member.getMpassword().trim().equals("")) {
			errors.rejectValue("mpassword", "errors.mpassword.required");
		} else {
			if(member.getMpassword().length() < 8) {
				errors.rejectValue("mpassword", "errors.mpassword.minlength", new Object[] {8}, "");
			}
		}
		
		//memail 검사(정규표현식으로 검사)
		if(member.getMemail() == null || member.getMemail().trim().equals("")) {
			errors.rejectValue("memail", "errors.memail.required");
		} else {
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";//javascript는 ""아니고 //
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(member.getMemail());
			
			if(!matcher.matches()){
				errors.rejectValue("memail", "errors.memail.invalid");
			}
		}
		
		//mtel 검사
		if(member.getMtel() == null || member.getMtel().trim().equals("")) {
			errors.rejectValue("mtel", "errors.mtel.required");
		}else {
			String regex = "\\d{3}-\\d{3,4}-\\d{4}$";//javascript는 ""아니고 //
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(member.getMtel());
			
			if(!matcher.matches()){
				errors.rejectValue("mtel", "errors.mtel.invalid");
			}
		}
	}
	
}
