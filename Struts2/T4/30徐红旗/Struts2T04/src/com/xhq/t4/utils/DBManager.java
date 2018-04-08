/**
 * 
 */
package com.xhq.t4.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author admin
 *
 */
public class DBManager {
	private static Connection con;
	private static final String DRIVERNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=db_user";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";
	
	public static Connection getConnection(){
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
