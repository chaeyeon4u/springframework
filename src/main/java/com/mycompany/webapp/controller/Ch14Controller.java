package com.mycompany.webapp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch14")
public class Ch14Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch14Controller.class);

	@Resource
	private DataSource dataSource;
	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");

		return "ch14/content";
	}
	
	@GetMapping("/testConnecToDB")
	public String testConnectTODB() throws Exception{
		//커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		logger.info("연결 성공");
		
		//커넥션 풀로 연결 객체를 반납하기
		conn.close();
		
		return "redirect:/ch14/content";
	}
	
	@GetMapping("/testInsert")
	public String testInsert() throws SQLException{
		//커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		
		try {
			//작업 처리
			String sql = "INSERT INTO board VALUES(SEQ_BNO.NEXTVAL, ?, ?, SYSDATE, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "오늘은 월요일");
			pstmt.setString(2, "즐거운 월요일");
			pstmt.setString(3, "user");
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("연결 성공");
		
		//커넥션 풀로 연결 객체를 반납하기
		conn.close();
		
		return "redirect:/ch14/content";
	}
	
	@GetMapping("/testSelect")
	public String testSelect() throws Exception{
		//커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		
		try {
			//작업 처리
			String sql = "SELECT bno, btitle, bcontent, bdate, mid FROM board";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				String mid = rs.getString("mid");
				logger.info(bno +"\t"+btitle+"\t"+bcontent+"\t"+ bdate+"\t"+mid);
			}
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("연결 성공");
		
		
		//커넥션 풀로 연결 객체를 반납하기!!
		conn.close();
		
		return "redirect:/ch14/content";
	}
	
	@GetMapping("/testUpdate")
	public String testUpdate() throws Exception{
		//커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		
		try {
			//작업 처리
			String sql = "Update board SET btitle=?, bcontent=? WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "배고파요");
			pstmt.setString(2, "점심 먹으러 언제 가요?");
			pstmt.setInt(3, 1);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("연결 성공");
		
		//커넥션 풀로 연결 객체를 반납하기
		conn.close();
		
		return "redirect:/ch14/content";
	}
	
	@GetMapping("/testDelete")
	public String testDelete() throws Exception{
		//커넥션 풀에서 연결 객체 하나를 가져오기
		Connection conn = dataSource.getConnection();
		
		try {
			//작업 처리
			String sql = "DELETE FROM board WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		logger.info("연결 성공");
		
		//커넥션 풀로 연결 객체를 반납하기
		conn.close();
		
		return "redirect:/ch14/content";
	}
}