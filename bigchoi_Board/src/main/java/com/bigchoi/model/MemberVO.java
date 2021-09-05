package com.bigchoi.model;

public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String email;
	private String address1; // 快祈锅龋
	private String address2; // 林家
	private String address3; // 惑技林家
	private int admin_check; // 0: 老馆荤侩磊, 1: 包府磊
	private int reg_date;
	private int money;
	private int point;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public int getAdmin_check() {
		return admin_check;
	}
	public void setAdmin_check(int admin_check) {
		this.admin_check = admin_check;
	}
	public int getReg_date() {
		return reg_date;
	}
	public void setReg_date(int reg_date) {
		this.reg_date = reg_date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", address1="
				+ address1 + ", address2=" + address2 + ", address3=" + address3 + ", admin_check=" + admin_check
				+ ", reg_date=" + reg_date + ", money=" + money + ", point=" + point + "]";
	}
	
	
	
	
	
	
	

}
