package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch14MemberDao;
import com.mycompany.webapp.dto.Ch14Member;

@Service//service로 관리 객체를 만들자 -> root에서 만들어진다.
public class Ch14MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberService.class);
	
	//열거 타입 선언
	public enum joinResult{
		SUCCESS,
		FAIL,
		DUPLICATED
	}
	
	public enum loginResult{
		SUCCESS,
		IDFAIL,
		PWFAIL
	}
	
	@Resource
	private Ch14MemberDao memberDao;
	
	//회원 가입을 처리하는 비즈니스 메소드(로직)
	public joinResult join(Ch14Member member) {
		try {
			//이미 가입된 아이디인지 확인
			Ch14Member dbMember = memberDao.selectByMid(member.getMid());//SELECT * FROM member WHERE mid=?
			
			//DB에 회원 정보 저장
			if(dbMember == null) {
				memberDao.insert(member);
				return joinResult.SUCCESS;
			}else {
				return joinResult.DUPLICATED;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return joinResult.FAIL;
		}
	}
	
	//로그인 처리하는 비즈니스 메소드(로직)
	public loginResult login(Ch14Member member) {
		//아이디 일치하는가
		Ch14Member dbMember = memberDao.selectByMid(member.getMid());
		
		
		if(dbMember == null) {
			return loginResult.IDFAIL;
		}else {
			//아이디의 비밀번호 일치하는가
			dbMember = memberDao.selectByMidMpassword(member);
			
			if(dbMember == null) {
				return loginResult.PWFAIL;
			}else {
				return loginResult.SUCCESS;
			}
		}		
	}
}
