package com.lh.qhit.gr3.xhq.t5.action;

import java.util.List;

import com.lh.qhit.gr3.xhq.t5.bean.User;
import com.lh.qhit.gr3.xhq.t5.service.UserService;
import com.lh.qhit.gr3.xhq.t5.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;
	private List<User> users;
	
	private UserService uService = new UserServiceImpl();
	/**
	 * @return
	 * ����û�
	 */
	public String add() {
		try {
			uService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	/**
	 * @return
	 * ɾ���û�
	 */
	public String delete() {
		try {
			uService.deleteUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	/**
	 * @return
	 * �Ȳ�ѯ��ǰ�û���Ϣ������ת���޸�ҳ��
	 */
	public String toUpdate() {
		try {
			user = uService.getUserById(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toUpdate";
	}
	/**
	 * @return
	 * �޸��û���Ϣ
	 */
	public String update() {
		try {
			uService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	/**
	 * @return
	 * ��ѯ���е��û�
	 */
	public String getAll() {
		try {
			users = uService.getAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "listUser";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
