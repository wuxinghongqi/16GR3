package com.xhq.sbm.provider.service.Impl;

import java.util.List;

import com.xhq.sbm.common.bean.PageBean;
import com.xhq.sbm.provider.bean.Provider;
import com.xhq.sbm.provider.dao.Impl.ProviderDaoImpl;
import com.xhq.sbm.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	@Override
	public List<Provider> getProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getProvider();
	}

	@Override
	public int getCount(String tablename, List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getCount(tablename, wheres, values);
	}

	@Override
	public PageBean getPageBean(PageBean pagebean) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getPageBean(pagebean);
	}

	@Override
	public Provider getProviderById(int ProviderId) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getProviderById(ProviderId);
	}

	@Override
	public int Updateprovider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().Updateprovider(provider);
	}

	@Override
	public int insertProvider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().insertProvider(provider);
	}

	@Override
	public PageBean getPageBeanByInfo(PageBean pagebean, List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getPageBeanByInfo(pagebean, wheres, values);
	}



}
