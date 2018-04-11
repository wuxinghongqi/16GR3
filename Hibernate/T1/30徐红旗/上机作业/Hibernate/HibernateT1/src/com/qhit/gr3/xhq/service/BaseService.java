package com.qhit.gr3.xhq.service;

import java.util.List;

public interface BaseService {
	public Object getObject(Class clazz,Integer id);
	public void add(Object object);
	public void delete(Object object);
	public void update(Object object);
	public List<Object> getAll(String hql);
}
