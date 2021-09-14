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
	
	public void insert(Ch14Member member) {
		//runtimeException 발생해서 try~catch문 안써도 됨
		sqlSessionTemplate.insert("member.insert", member);
	}

	public Ch14Member selectByMid(String mid) {
		return sqlSessionTemplate.selectOne("member.selectByMid", mid);
	}
	
	/*public Ch14Member selectByMidMpassword(Ch14Member member) {
		return sqlSessionTemplate.selectOne("member.selectByMidMpassword", member);
	}*/
}
