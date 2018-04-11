package com.qhit.lh.xhq.bean;

/**
 * Info entity. @author MyEclipse Persistence Tools
 */

public class Info implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String account;
	private String pwd;
	
	private User user;
	// Constructors

	/** default constructor */
	public Info() {
	}
	
	/** full constructor */
	public Info(String name, String account, String pwd) {
		this.name = name;
		this.account = account;
		this.pwd = pwd;
	}
	
	public Info(Integer id, String name, String account, String pwd, User user) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.pwd = pwd;
		this.user = user;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}