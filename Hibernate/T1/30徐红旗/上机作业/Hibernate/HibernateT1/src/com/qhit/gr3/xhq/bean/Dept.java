package com.qhit.gr3.xhq.bean;

public class Dept {
	private int id;
	private String dname;
	
	
	public Dept(String dname) {
		super();
		this.dname = dname;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(int id, String dname) {
		super();
		this.id = id;
		this.dname = dname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", dname=" + dname + "]";
	}
}
