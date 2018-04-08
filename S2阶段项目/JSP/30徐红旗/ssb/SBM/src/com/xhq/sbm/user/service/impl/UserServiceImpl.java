package com.xhq.sbm.user.service.impl;

import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.user.bean.User;
import com.xhq.sbm.user.dao.Impl.UserDaoImpl;
import com.xhq.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getUser(userName, userPassword);
	}

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getPageBean(pageBean);
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().insertUser(user);
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getUserById(userId);
	}

	@Override
	public int upUser(User u, int userId) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().upUser(u, userId);
	}

	@Override
	public int delUser(int userId) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().delUser(userId);
	}

	@Override
	public PageBean getUserPageBean(PageBean pagebean,String userName) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getUserPageBean(pagebean, userName);
	}


	@Override
	public User getUserByInfo(int userId) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getUserByInfo(userId);
	}

	@Override
	public int upUserPwd(User user, int userId) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().upUserPwd(user, userId);
	}


}
