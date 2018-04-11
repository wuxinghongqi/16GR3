package com.qhit.lh.xhq.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private Integer uage;
	private String birthday;
	private Integer deptid;
	
	private Info info;
	private Dept dept;
	
	
	public User() {
		super();
	}
	public User(String uname, Integer uage, String birthday, Integer deptid,
			Info info, Dept dept) {
		super();
		this.uname = uname;
		this.uage = uage;
		this.birthday = birthday;
		this.deptid = deptid;
		this.info = info;
		this.dept = dept;
	}
	public User(String uname, Integer uage, String birthday, Integer deptid) {
		super();
		this.uname = uname;
		this.uage = uage;
		this.birthday = birthday;
		this.deptid = deptid;
	}
	public User(Integer uid, String uname, Integer uage, String birthday,
			Integer deptid, Info info, Dept dept) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uage = uage;
		this.birthday = birthday;
		this.deptid = deptid;
		this.info = info;
		this.dept = dept;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getUage() {
		return uage;
	}
	public void setUage(Integer uage) {
		this.uage = uage;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uage=" + uage
				+ ", birthday=" + birthday + ", deptid=" + deptid + ", info="
				+ info + ", dept=" + dept + "]";
	}
	
}