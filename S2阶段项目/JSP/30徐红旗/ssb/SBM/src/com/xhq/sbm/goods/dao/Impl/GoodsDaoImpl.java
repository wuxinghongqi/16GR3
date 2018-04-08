package com.xhq.sbm.goods.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xhq.sbm.goods.bean.Goods;
import com.xhq.sbm.goods.dao.GoodsDao;
import com.xhq.sbm.utils.DBManager;

public class GoodsDaoImpl implements GoodsDao {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	@Override
	public Goods getGoods(String goodsName) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		Goods good=null;
		String sql="select * from tb_goods where goodsName = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ResultSet rul=ps.executeQuery();
			while(rul.next()) {
				good=new Goods(
						rul.getInt("goodsId"),
						rul.getString("goodsName"),
						rul.getInt("goodsNum"),
						rul.getFloat("goodsPrice"), 
						rul.getString("goodsUnit"),
						rul.getString("goodsIntro"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return good;
	}
	@Override
	public int upGoods(int goodsNum, int goodsId) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="update tb_goods set goodsNum = ? where goodsId = ?";
				try {
					ps=con.prepareStatement(sql);
					ps.setInt(1, goodsNum);
					ps.setInt(2, goodsId);
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
