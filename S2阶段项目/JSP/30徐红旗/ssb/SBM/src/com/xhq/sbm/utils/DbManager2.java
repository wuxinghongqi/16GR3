package com.xhq.sbm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager2 {
	public static Connection con;
	private static String DriverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=db_sbm";
	private static String username="sa";
	private static String password="123456";
	
	public static Connection getConnection() {
		try {
			Class.forName(DriverName);
			con=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void Close(Statement ps,Connection con) {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
