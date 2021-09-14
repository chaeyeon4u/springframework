package com.mycompany.webapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mycompany.webapp.dto.Ch14Board;

//interface : 사용 방법 기술
//Mapper 어노테이션 사용 
//: 메서드 이름이 member.xml의 id가 된다.
//com.mycompany.webapp.dao.Ch14Board는 namespace가 된다.
@Mapper
public interface Ch14BoardDao {//구현 객체는 myBatis가 제공
	
	public List<Ch14Board> selectByPage();
	public int count();
	public Ch14Board selectByBno(int bno);
	public int insert(Ch14Board board);
	public int deleteByBno(int bno);
	public int update(Ch14Board board);
	
}
