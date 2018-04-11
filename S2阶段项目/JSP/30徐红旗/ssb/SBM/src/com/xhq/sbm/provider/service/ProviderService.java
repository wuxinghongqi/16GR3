package com.xhq.sbm.provider.service;

import java.util.List;

import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.provider.bean.Provider;

public interface ProviderService {

	public List<Provider> getProvider();
	public int getCount(String tablename,List<String> wheres,List<String> values);
	public PageBean getPageBean(PageBean pagebean);
	public Provider getProviderById(int ProviderId);
	public int Updateprovider(Provider provider);
	public int insertProvider(Provider provider);
	public PageBean getPageBeanByInfo(PageBean pagebean,List<String> wheres,List<String> values);
}
