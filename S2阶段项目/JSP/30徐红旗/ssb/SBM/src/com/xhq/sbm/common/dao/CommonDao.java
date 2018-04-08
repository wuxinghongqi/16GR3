package com.xhq.sbm.common.dao;

import java.util.List;

public interface CommonDao {
	public int getCount(String tablename,List<String> wheres,List<String> values);
}
