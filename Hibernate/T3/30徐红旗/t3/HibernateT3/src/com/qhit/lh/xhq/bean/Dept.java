package com.qhit.lh.xhq.bean;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer id;
	private String dname;

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** full constructor */
	public Dept(String dname) {
		this.dname = dname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", dname=" + dname + "]";
	}

}