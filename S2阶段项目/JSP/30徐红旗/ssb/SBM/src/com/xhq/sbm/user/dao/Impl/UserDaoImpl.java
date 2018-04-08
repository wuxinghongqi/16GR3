package com.xhq.sbm.user.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.user.bean.User;
import com.xhq.sbm.user.dao.UserDao;
import com.xhq.sbm.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	//获取user
	public User getUser(String userName, String userPassword) {
		 User user=null;
		String sql="select * from tb_user where userName = ? and userPassword = ?";
		con=DBManager.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rul=ps.executeQuery();
			if(rul.next()) {
				System.out.println("我是Dao第一次："+sql);
				user=new User(
						rul.getInt("userId"),
						rul.getString("userName"),
						rul.getString("userPassword"),
						rul.getString("userSex"),
						rul.getInt("userAge"),
						rul.getString("telephone"),
						rul.getString("address"),
						rul.getString("pic"),
						rul.getInt("type")
						);
				System.out.println("我是Dao第二次："+sql);
			}
			System.out.println("DaouserPassword"+userPassword);
			System.out.println("我是Dao第三次："+sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return user;
	}

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		User user=null;
		con=DBManager.getConnection();
		String sql="select top "
				+ pageBean.getPagesize()
				+ " * from tb_user where tb_user.userId not in (select top "
				+ pageBean.getPagesize()*(pageBean.getP()-1)
				+ " userId from tb_user)";
		try {
			ps=con.prepareStatement(sql);
			ResultSet rul=ps.executeQuery();
			while(rul.next()) {
				user=new User(rul.getInt("userId"),
								rul.getString("userName"), 
								rul.getString("userPassword"), 
								rul.getString("userSex"),
								rul.getInt("userAge"), 
								rul.getString("telephone"), 
								rul.getString("address"), 
								rul.getString("pic"), 
								rul.getInt("type"));
				pageBean.addData(user);
			}
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return pageBean;
	}
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="insert into tb_user values(?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getType());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return 0;
	}
	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		User user=null;
		int userid=Integer.parseInt(userId);
		con=DBManager.getConnection();
		String sql="select * from tb_user where userId = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rul=ps.executeQuery();
			if(rul.next()) {
				user=new User(
						rul.getInt("userId"),
						rul.getString("userName"),
						rul.getString("userPassword"),
						rul.getString("userSex"), 
						rul.getInt("userAge"),
						rul.getString("telephone"), 
						rul.getString("address"), 
						rul.getString("pic"), 
						rul.getInt("type")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return user;
	}
	@Override
	public int upUser(User u, int userId) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="update tb_user set userName = ?,userPassword=?,userSex=?,userAge=?,telephone=?,address=?,pic=?,type=? where userId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,u.getUserName());
			ps.setString(2,u.getUserPassword()); 
			ps.setString(3,u.getUserSex());
			System.out.println("Impl"+u.getUserAge());
			ps.setInt(4,u.getUserAge());
			ps.setString(5,u.getTelephone()); 
			ps.setString(6,u.getAddress()); 
			ps.setString(7,u.getPic());
			ps.setInt(8,u.getType());
			ps.setInt(9,userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		
		return 0;
	}
	@Override
	public int delUser(int userId) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="delete from tb_user where userId = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return 0;
	}
	@Override
	public PageBean getUserPageBean(PageBean pagebean,String userName) {
		// TODO Auto-generated method stub
		User user=null;
		System.out.println("Dao Pagesize:"+pagebean.getPagesize()+"Dao  P:"+pagebean.getP());
		con=DBManager.getConnection();
		String sql="select top "
				+ pagebean.getPagesize()
				+ " * from tb_user u where u.userName = ? and u.userId not in (select top "
				+ pagebean.getPagesize()*(pagebean.getP()-1)
				+ " userId from tb_user where userName = ?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userName);
			ResultSet rul = ps.executeQuery();
			while(rul.next()) {
				user=new User(rul.getInt("userId"),
						rul.getString("userName"), 
						rul.getString("userPassword"), 
						rul.getString("userSex"),
						rul.getInt("userAge"), 
						rul.getString("telephone"),
						rul.getString("address"), 
						rul.getString("pic"), 
						rul.getInt("type"));
				
				pagebean.addData(user);
			}
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return pagebean;
	}
	@Override
	public User getUserByInfo(int userId) {
		// TODO Auto-generated method stub
		User user=null;
		con=DBManager.getConnection();
		String sql="select * from tb_user where userId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rul=ps.executeQuery();
			while(rul.next()) {
				user=new User(rul.getString("userName"),
						rul.getString("userPassword"), 
						rul.getString("userSex"), 
						rul.getInt("userAge"), 
						rul.getString("telephone"), 
						rul.getString("address"),
						rul.getString("pic"),
						rul.getInt("type")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		
		return user;
	}

	@Override
	public int upUserPwd(User user, int userId) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="update tb_user set userPassword=? where userId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,user.getUserPassword()); 
			ps.setInt(2,userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return 0;
	}

}
