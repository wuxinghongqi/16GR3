package com.jay.t3.bean;

import java.util.Date;

public class User {
	private String uname;
	private String upwd;
	private int age;
	private Date birthday;
	private String sex;
	private String address;
	private String telphone;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uname, String upwd, int age, Date birthday, String sex, String address, String telphone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.telphone = telphone;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	

}
