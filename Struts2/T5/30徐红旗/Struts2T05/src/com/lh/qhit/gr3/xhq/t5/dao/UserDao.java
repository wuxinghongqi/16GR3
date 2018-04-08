package com.lh.qhit.gr3.xhq.t5.dao;

import java.util.List;

import com.lh.qhit.gr3.xhq.t5.bean.User;

public interface UserDao {

	/**
	 * 查
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public int addUser(User user) throws Exception;
	/**
	 * 删除
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public int deleteUser(User user) throws Exception;
	/**
	 * 改
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public int updateUser(User user) throws Exception;
	
	public List<User> getAllUser() throws Exception;
	
	/**
	 * @param user
	 * @return
	 * 根据id查用户
	 * @throws Exception 
	 */
	public User getUserById(User user) throws Exception;
	
}
