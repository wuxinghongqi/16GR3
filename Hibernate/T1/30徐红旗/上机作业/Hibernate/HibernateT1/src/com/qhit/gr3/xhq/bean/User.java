package com.qhit.gr3.xhq.bean;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private int uage;
	private String birthday;
	
	
	public User(String uname, String upwd, int uage, String birthday) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.uage = uage;
		this.birthday = birthday;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String upwd, int uage, String birthday) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.uage = uage;
		this.birthday = birthday;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
				+ ", uage=" + uage + ", birthday=" + birthday + "]";
	}
}
