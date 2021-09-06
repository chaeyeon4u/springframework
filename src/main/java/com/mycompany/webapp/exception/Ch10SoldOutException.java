package com.mycompany.webapp.exception;

public class Ch10SoldOutException extends RuntimeException {// try-catch, throws 안쓰려면 RuntimeException로 만들라
	public Ch10SoldOutException() {//예외처리 생성자1
		super("품절");//예외에 맞는 내용
	}
	
	public Ch10SoldOutException(String message) {//예외처리 생성자2
		super(message);
	}
}
