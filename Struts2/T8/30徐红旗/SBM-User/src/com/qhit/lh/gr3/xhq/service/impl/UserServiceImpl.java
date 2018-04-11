package com.qhit.lh.gr3.xhq.service.impl;

import java.util.List;

import com.qhit.lh.gr3.xhq.bean.User;
import com.qhit.lh.gr3.xhq.dao.UserDao;
import com.qhit.lh.gr3.xhq.dao.impl.UserDaoImpl;
import com.qhit.lh.gr3.xhq.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud=new UserDaoImpl();
	@Override
	public User getUser(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return ud.getUser(userName, userPassword);
	}
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return ud.insertUser(user);
	}
	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return ud.getUserById(userId);
	}

	@Override
	public int upUser(User u, int userId) {
		// TODO Auto-generated method stub
		return ud.upUser(u, userId);
	}

	@Override
	public int delUser(int userId) {
		// TODO Auto-generated method stub
		return ud.delUser(userId);
	}



	@Override
	public User getUserByInfo(int userId) {
		// TODO Auto-generated method stub
		return ud.getUserByInfo(userId);
	}

	@Override
	public int upUserPwd(User user, int userId) {
		// TODO Auto-generated method stub
		return ud.upUserPwd(user, userId);
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cyh.user.service.UserService#getAllUser()
	 */
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return ud.getAllUser();
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cyh.user.service.UserService#getUserByName(java.lang.String)
	 */
	@Override
	public List<User> getUserByName(String userName) {
		// TODO Auto-generated method stub
		return ud.getUserByName(userName);
	}


}
