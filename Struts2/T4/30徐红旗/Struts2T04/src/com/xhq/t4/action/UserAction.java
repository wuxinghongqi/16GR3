package com.xhq.t4.action;

import com.opensymphony.xwork2.Action;
import com.xhq.t4.bean.User;
import com.xhq.t4.service.UserService;
import com.xhq.t4.service.impl.UserServiceImpl;

public class UserAction implements Action {
private User user;
private UserService uService = new UserServiceImpl();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int row=uService.addUser(user);
		if(row > 0) {
			return SUCCESS;
			}else
		return ERROR;
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
