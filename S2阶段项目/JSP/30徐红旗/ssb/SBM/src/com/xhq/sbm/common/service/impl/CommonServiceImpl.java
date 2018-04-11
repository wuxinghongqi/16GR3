package com.xhq.sbm.common.service.impl;

import java.util.List;

import com.xhq.sbm.common.dao.Impl.CommonDaoImpl;
import com.xhq.sbm.common.service.CommonService;

public class CommonServiceImpl implements CommonService{

	@Override
	public int getCount(String tablename, List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new CommonDaoImpl().getCount(tablename, wheres, values);
	}

}
