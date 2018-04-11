package com.xhq.sbm.account.service.Impl;

import java.util.List;

import com.xhq.sbm.account.bean.AddAccount;
import com.xhq.sbm.account.dao.Impl.AccountDaoImpl;
import com.xhq.sbm.account.service.AccountService;
import com.xhq.sbm.common.bean.PageBean;

public class AccountServiceImpl implements AccountService {

	@Override
	public PageBean getAllAccount(PageBean pBean) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().getAllAccount(pBean);
	}

	@Override
	public int insertAccount(AddAccount adda) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().insertAccount(adda);
	}

	@Override
	public PageBean getPagebeanByTerm(List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().getPagebeanByTerm(wheres, values);
	}

	@Override
	public int delAccount(int accountId) {
		// TODO Auto-generated method stub
		
		return new AccountDaoImpl().delAccount(accountId);
	}

	@Override
	public int updateAccount(int providerid, int isPayed, int businessNum,int accountId) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().updateAccount(providerid, isPayed, businessNum, accountId);
	}

}
