package com.xhq.sbm.provider.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.provider.bean.Provider;
import com.xhq.sbm.provider.dao.ProviderDao;
import com.xhq.sbm.utils.DBManager;

public class ProviderDaoImpl implements ProviderDao{
	private static Connection con=null;
	private static PreparedStatement ps=null;
	@Override
	public List<Provider> getProvider() {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		List<Provider> list=new ArrayList<>();
		Provider provider=null;
		String sql="select * from tb_provider";
		try {
			ps=con.prepareStatement(sql);
			ResultSet rul=ps.executeQuery();
			while(rul.next()) {
				provider=new Provider(
						rul.getInt("providerId"), 
						rul.getString("providerName"), 
						rul.getString("providerDetail"), 
						rul.getString("contact"), 
						rul.getString("telephone"), 
						rul.getString("facsimile"), 
						rul.getString("address"));
				list.add(provider);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return list;
	}
	@Override
	public int getCount(String tablename, List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="select count(*) as cnt from "
				+ tablename;
		if(wheres != null && values != null) {
			sql+=" where ";
			for(int i=0;i<wheres.size();i++) {
				sql+=wheres.get(i)+" = '"+values.get(i)+"' and ";
			}
			sql+="1 = 1";
		}
		try {
			ps=con.prepareStatement(sql);
			ResultSet rul=ps.executeQuery();
			if(rul.next()) {
				return rul.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return 0;
	}
	@Override
	public PageBean getPageBean(PageBean pagebean) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		Provider provider=null;
		String sql="select top "
				+ pagebean.getPagesize()
				+ " * from tb_provider where providerId not in (select top "
				+ pagebean.getPagesize()*(pagebean.getP()-1)
				+ " providerId from tb_provider);";
		try {
			ps=con.prepareStatement(sql);
			ResultSet rul=ps.executeQuery();
			while(rul.next()) {
				provider=new Provider
					(
						rul.getInt("providerId"), 
						rul.getString("providerName"), 
						rul.getString("providerDetail"), 
						rul.getString("contact"), 
						rul.getString("telephone"), 
						rul.getString("facsimile"), 
						rul.getString("address")
					);
						pagebean.addData(provider);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}
		return pagebean;
	}
	@Override
	public Provider getProviderById(int ProviderId) {
		// TODO Auto-generated method stub
		Provider provider=null;
		con=DBManager.getConnection();
		String sql="select * from tb_provider where ProviderId = ?";
				try {
					ps=con.prepareStatement(sql);
					ps.setInt(1, ProviderId);
					ResultSet rul=ps.executeQuery();
					if(rul.next()) {
						provider=new Provider
							(
								rul.getInt("providerId"),
								rul.getString("providerName"), 
								rul.getString("providerDetail"),
								rul.getString("contact"), 
								rul.getString("telephone"), 
								rul.getString("facsimile"), 
								rul.getString("address")
							);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBManager.close(ps, con);
				}
		return provider;
	}
	@Override
	public int Updateprovider(Provider provider) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="update tb_provider set providerName = ?,providerDetail = ?,contact = ?,telephone = ?,facsimile = ?,address = ? where providerId = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,provider.getProviderName()); 
			ps.setString(2,provider.getProviderDetail()); 
			ps.setString(3,provider.getContact()); 
			ps.setString(4,provider.getTelephone()); 
			ps.setString(5,provider.getFacsimile()); 
			ps.setString(6,provider.getAddress());
			ps.setInt(7,provider.getProviderId());
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
	public int insertProvider(Provider provider) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="insert into tb_provider values(?,?,?,?,?,?);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,provider.getProviderName()); 
			ps.setString(2,provider.getProviderDetail()); 
			ps.setString(3,provider.getContact()); 
			ps.setString(4,provider.getTelephone()); 
			ps.setString(5,provider.getFacsimile()); 
			ps.setString(6,provider.getAddress());
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
	public PageBean getPageBeanByInfo(PageBean pagebean,List<String> wheres,List<String> values) {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		Provider provider=null;
		String sql="select top "
				+ pagebean.getPagesize()
				+ " * from tb_provider where tb_provider.providerId not in (select top "
				+ pagebean.getPagesize()*(pagebean.getP()-1)
				+ " providerId from tb_provider)";
		if(wheres !=null &&values != null) {
			sql+=" and ";
			for(int i=0;i<wheres.size();i++) {
				sql+=wheres.get(i)+" = '"+values.get(i)+"' and ";
			}
			sql+=" 1 = 1";
		}
		try {
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ResultSet rul=ps.executeQuery();
			while(rul.next()) {
				provider=new Provider(
						rul.getInt("providerId"),
						rul.getString("providerName"), 
						rul.getString("providerDetail"),
						rul.getString("contact"), 
						rul.getString("telephone"), 
						rul.getString("facsimile"), 
						rul.getString("address")
						);
				pagebean.addData(provider);
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

}
