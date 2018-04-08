package com.xhq.t4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xhq.t4.bean.User;
import com.xhq.t4.dao.UserDao;
import com.xhq.t4.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;

	public int addUser(User user) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
				String sql = "insert into t_user values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setString(3, user.getEducat());
			ps.setString(4, user.getSex());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return 0;
	}

}
