package com.qhit.xhq.action;

import com.opensymphony.xwork2.Action;

public class HelloWorld implements Action {
	private String name="我是陈益辉";
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "zxc";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
