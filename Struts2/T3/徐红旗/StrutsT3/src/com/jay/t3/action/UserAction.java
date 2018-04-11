package com.jay.t3.action;

import com.jay.t3.bean.User;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
private User user;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
