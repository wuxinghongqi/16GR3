package com.xhq.sbm.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager {
	private static Connection con;
	private static String DriverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//拿到JDBC驱动
	private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=db_sbm";//通过服务器端口号1433连接数据库
	private static String username="sa";//账号
	private static String password="123456";//密码
	
	public static Connection getConnection() {
			try {
				Class.forName(DriverName);//加载JDBC驱动，注册DriverManager
				con=DriverManager.getConnection(url, username, password);//通过DriverManager获得连接驱动
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return con;
	}
	
	public static void close(Statement statement,Connection con){
		try {
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
