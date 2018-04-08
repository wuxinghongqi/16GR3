package com.qhit.lh.gr3.xhq.service;

import java.util.List;

import com.qhit.lh.gr3.xhq.bean.User;

public interface UserService {
	
	public User getUser(String userName,String userPassword);
	public int insertUser(User user);
	public User getUserById(String userId);
	public int upUser(User u,int userId);
	public int delUser(int userId);
	public User getUserByInfo(int userId);
	public int upUserPwd(User user,int userId);
	public List<User> getAllUser();
	public List<User> getUserByName(String userName);
}
