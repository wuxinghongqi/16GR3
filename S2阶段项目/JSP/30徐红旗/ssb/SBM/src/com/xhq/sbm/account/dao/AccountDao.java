package com.xhq.sbm.account.dao;

import java.util.List;

import com.xhq.sbm.account.bean.AddAccount;
import com.xhq.sbm.common.bean.PageBean;

public interface AccountDao {
	public PageBean getAllAccount(PageBean pageBean);
	public int insertAccount(AddAccount adda);
	public PageBean getPagebeanByTerm(List<String> wheres,List<String> values);
	public int delAccount(int accountId);
	public int updateAccount(int providerid,int isPayed,int businessNum,int accountId);
}
