package com.lh.qhit.gr3.xhq.t5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lh.qhit.gr3.xhq.t5.bean.User;
import com.lh.qhit.gr3.xhq.t5.dao.UserDao;
import com.lh.qhit.gr3.xhq.t5.utils.DBManager;

public class UserDaoImpl implements UserDao {

	private Connection con;
	private PreparedStatement ps;

	/* (non-Javadoc)
	 * @see com.jay.t5.dao.UserDao#addUser(com.jay.t5.bean.User)
	 */
	@Override
	public int addUser(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "insert into t_user values (?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getEnable());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}

	/* (non-Javadoc)
	 * @see com.jay.t5.dao.UserDao#deleteUser(com.jay.t5.bean.User)
	 */
	@Override
	public int deleteUser(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "delete from t_user where userId = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getId());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}

	/* (non-Javadoc)
	 * @see com.jay.t5.dao.UserDao#updateUser(com.jay.t5.bean.User)
	 */
	@Override
	public int updateUser(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "update t_user set uname = ?, upwd = ?, birthday = ?, sex = ?, enable = ? where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getEnable());
		ps.setInt(6, user.getId());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}

	/* (non-Javadoc)
	 * @see com.jay.t5.dao.UserDao#getAllUser(com.jay.t5.bean.User)
	 */
	@Override
	public List<User> getAllUser() throws Exception {
		User user = null;
		List<User> users = new ArrayList<>();
		con = DBManager.getConnection();
		String sql = "select * from t_users";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new User(
					rs.getInt("userId"), 
					rs.getString("uname"), 
					rs.getString("upwd"), 
					rs.getString("birthday"), 
					rs.getString("sex"), 
					rs.getInt("enable"));
			users.add(user);
		}
		DBManager.close(ps, con);
		return users;
	}

	@Override
	public User getUserById(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "select * from t_users where userId = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User(
					rs.getInt("userId"), 
					rs.getString("uname"), 
					rs.getString("upwd"), 
					rs.getString("birthday"), 
					rs.getString("sex"), 
					rs.getInt("enable"));
		}
		DBManager.close(ps, con);
		return user;
	}
	
}
