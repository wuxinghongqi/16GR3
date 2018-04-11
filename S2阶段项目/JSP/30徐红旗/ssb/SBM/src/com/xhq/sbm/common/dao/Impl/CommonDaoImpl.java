package com.xhq.sbm.common.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xhq.sbm.common.dao.CommonDao;
import com.xhq.sbm.utils.DBManager;


public class CommonDaoImpl implements CommonDao {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	@Override
	public int getCount(String tablename, List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		int count=0;
		String sql="select count(*) as cnt from "
				+ tablename;
		if(wheres != null && wheres.size() > 0) {
			sql+=" where ";
			for(int i=0;i<wheres.size();i++) {
				sql+=wheres.get(i)+" = '"+values.get(i)+"' and ";
			}
			sql+="1 = 1";
		}
		try {
			ps=con.prepareStatement(sql);
			ResultSet rul = ps.executeQuery();
			
			if(rul.next()) {
				System.out.println(sql);
				return rul.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return 0;
	}

}
