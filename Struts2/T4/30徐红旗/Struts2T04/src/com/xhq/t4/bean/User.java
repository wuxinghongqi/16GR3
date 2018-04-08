package com.xhq.t4.bean;

public class User {
	private String uname;
	private String upwd;
	private String[] like;
	private String educat;
	private String sex;
	
	
	public User() {
		super();
	}
	
	
	public User(String uname, String upwd, String[] like, String educat, String sex) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.like = like;
		this.educat = educat;
		this.sex = sex;
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
	public String[] getLike() {
		return like;
	}
	public void setLike(String[] like) {
		this.like = like;
	}
	public String getEducat() {
		return educat;
	}
	public void setEducat(String educat) {
		this.educat = educat;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
