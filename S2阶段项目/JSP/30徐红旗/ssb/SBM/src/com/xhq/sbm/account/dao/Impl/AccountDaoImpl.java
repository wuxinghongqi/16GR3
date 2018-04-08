package com.xhq.sbm.account.dao.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhq.sbm.account.bean.AccountRetrieval;
import com.xhq.sbm.account.bean.AddAccount;
import com.xhq.sbm.account.dao.AccountDao;
import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.utils.DBManager;

public class AccountDaoImpl implements AccountDao {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	@Override
	public PageBean getAllAccount(PageBean pBean) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		AccountRetrieval ar=null;
		String sql="select top "
				+ pBean.getPagesize()
				+ " a.accountId,g.goodsName,a.businessNum,a.totalPrice,a.isPayed,p.providerName,"
				+ "g.goodsIntro,a.accountDate from tb_account a left join tb_goods g on a.goodsId = g.goodsId "
				+ "left join tb_provider p on a.providerId = p.providerId "
				+ "where a.accountId not in ( select top "
				+ pBean.getPagesize()*(pBean.getP()-1)
				+ " accountId from tb_account);"; 
		try {
			ps=con.prepareStatement(sql);
			ResultSet rul=ps.executeQuery();
			while(rul.next()) {
				ar=new AccountRetrieval(rul.getInt("accountId"),
						rul.getString("goodsName"), 
						rul.getInt("businessNum"), 
						rul.getFloat("totalPrice"), 
						rul.getInt("isPayed"), 
						rul.getString("providerName"), 
						rul.getString("goodsIntro"),
						rul.getDate("accountDate"));
				pBean.addData(ar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return pBean;
	}
	
	@Override
	public int insertAccount(AddAccount adda) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="insert into tb_account values(?,?,?,getDate(),?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,adda.getProviderId());
			ps.setFloat(2,adda.getTotalPrice());
			ps.setInt(3,adda.getIsPayed());
			ps.setInt(4,adda.getGoodsId());
			ps.setInt(5,adda.getBusinessNum());
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
	public PageBean getPagebeanByTerm(List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		PageBean pagebean=new PageBean();
		AccountRetrieval ar=null;
		List<AccountRetrieval> list=new ArrayList<AccountRetrieval>();
		String sql="select a.accountId,g.goodsName,a.businessNum,a.totalPrice,a.isPayed,p.providerName,"
				+ "g.goodsIntro,a.accountDate from tb_account a left join tb_goods g on a.goodsId = g.goodsId "
				+ "left join tb_provider p on a.providerId = p.providerId ";
		if(wheres.size() > 0 && values.size() > 0) {
			sql+="where ";
			for(int i=0;i<wheres.size();i++) {
				sql+=wheres.get(i)+" = '"+values.get(i)+"' and ";
			}
			sql+="1 = 1";
		}
		try {
			ps=con.prepareStatement(sql);
			ResultSet rul=ps.executeQuery();
			while(rul.next()) {
				ar=new AccountRetrieval(rul.getInt("accountId"),
						rul.getString("goodsName"), 
						rul.getInt("businessNum"), 
						rul.getFloat("totalPrice"), 
						rul.getInt("isPayed"), 
						rul.getString("providerName"), 
						rul.getString("goodsIntro"),
						rul.getDate("accountDate"));
					list.add(ar);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		pagebean.setCount(list.size());
		pagebean.setData(list);
		pagebean.setPagesize(list.size());
		pagebean.setP(1);
		return pagebean;
}

	@Override
	public int delAccount(int accountId) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="delete from tb_account where accountId = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, accountId);
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
	public int updateAccount(int providerid, int isPayed, int businessNum,int accountId) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="update tb_account set providerId = ?,isPayed = ?,businessNum = ? where accountId = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, providerid);
			ps.setInt(2, isPayed);
			ps.setInt(3, businessNum);
			ps.setInt(4, accountId);
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