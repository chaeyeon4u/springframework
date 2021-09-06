package com.mycompany.webapp.dto;

import java.util.List;

import lombok.Data;

@Data
public class Ch11Member {
	private String mid;//넘어오는 파라미터랑 값 같아야해
	private String mname;
	private String mpassword;
	private String mnation;
	private String mtype;

}
