package com.qhit.lh.xhq.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.xhq.dao.BaseDao;
import com.qhit.lh.xhq.util.HibernateSessionFactory;


public class BaseDaoImpl implements BaseDao {

	@Override
	public Object getObject(Class clazz,Integer id) {
		// TODO Auto-generated method stub
		Object object=null;
		Session session=HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		object=session.get(clazz, id);
		ts.commit();
		HibernateSessionFactory.closeSession();
		return object;
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		session.save(object);
		ts.commit();
		
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		session.delete(object);
		ts.commit();
		
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		session.update(object);
		ts.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	public List<Object> getAll(String hql) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		
		List<Object> list=new ArrayList<Object>();
		list=session.createQuery(hql).list();
		ts.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}

}
