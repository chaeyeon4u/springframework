package com.mycompany.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Member;

@Repository
public class Ch14MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberDao.class);

	//Ch14_datasource.xml에서 bean 정의되어있음
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Ch14Member member) {
		//sqlSessionTemplate.insert -> runtimeException 발생해서 try~catch문 안써도 됨
		//try/cahch 쓰면 안된다. throws는 가능
		//member.insert는 mapper-config.xml의 namespace활용한 것 뒤의 member는 매개변수
		//insert/delete/update 행 수를 return한다.
		int rows = sqlSessionTemplate.insert("mybatis.mapper.member.insert", member);
		return rows;
	}

	public Ch14Member selectByMid(String mid) {
		Ch14Member member = sqlSessionTemplate.selectOne("mybatis.mapper.member.selectByMid", mid);
		return member;
	}
	
}
