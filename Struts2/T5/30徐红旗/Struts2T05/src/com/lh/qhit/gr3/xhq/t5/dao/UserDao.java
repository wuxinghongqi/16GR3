package com.lh.qhit.gr3.xhq.t5.dao;

import java.util.List;

import com.lh.qhit.gr3.xhq.t5.bean.User;

public interface UserDao {

	/**
	 * ��
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public int addUser(User user) throws Exception;
	/**
	 * ɾ��
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public int deleteUser(User user) throws Exception;
	/**
	 * ��
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public int updateUser(User user) throws Exception;
	
	public List<User> getAllUser() throws Exception;
	
	/**
	 * @param user
	 * @return
	 * ����id���û�
	 * @throws Exception 
	 */
	public User getUserById(User user) throws Exception;
	
}
