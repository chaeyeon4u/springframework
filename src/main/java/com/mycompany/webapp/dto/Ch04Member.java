package com.mycompany.webapp.dto;

public class Ch04Member {

	private String mid;//넘어오는 파라미터랑 값 같아야해
	private String mpassword;
	private String memail;
	private String mtel;
	
	//private String city;
	private Ch07City city;
	
	public Ch07City getCity() {
		return city;
	}
	public void setCity(Ch07City city) {
		this.city = city;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	
	
}
