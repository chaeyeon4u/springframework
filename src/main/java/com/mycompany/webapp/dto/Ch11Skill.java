package com.mycompany.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//매개값 없는 생성자
@AllArgsConstructor//모든 매개변수 가지고있는 생성자 만들겠다.
public class Ch11Skill {
	private int code;
	private String label;
	
	/*public Ch11Skill() {
	}*/
	
	/*public Ch11Skill(int code, String label) {
		super();
		this.code = code;
		this.label = label;
	}*/
	
	
}