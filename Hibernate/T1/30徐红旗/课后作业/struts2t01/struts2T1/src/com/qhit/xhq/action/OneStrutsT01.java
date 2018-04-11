package com.qhit.xhq.action;

import com.opensymphony.xwork2.Action;

public class OneStrutsT01 implements Action {
	private String content;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content="Hello,我的第一个Struts";
		return "HelloOneS";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
