package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch14BoardDao;
import com.mycompany.webapp.dto.Ch14Board;
import com.mycompany.webapp.dto.Pager;

@Service
public class Ch14BoardService {
	private static final Logger logger = LoggerFactory.getLogger(Ch14BoardService.class);
	
	//알아서 주입해준다.
	@Resource
	private Ch14BoardDao boardDao;
	
	//게시물 목록
	public List<Ch14Board> getBoards(Pager pager) {
		return boardDao.selectByPage(pager);
	}
	
	//게시물 하나
	public Ch14Board getBoard(int bno) {
		return boardDao.selectByBno(bno);
	}
	
	//개시물 개수
	public int getTotalBoardNum() {
		return boardDao.count();
	}
	
	//게시물 작성
	public void writeBoard(Ch14Board board) {
		boardDao.insert(board);
	}
	
	//게시물 수정
	public void updateBoard(Ch14Board board) {
		boardDao.update(board);
	}
	
	//게시물 삭제
	public void removeBoard(int bno) {
		boardDao.deleteByBno(bno);
	}
	
}
