package com.qhit.gr3.xhq.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.gr3.cyh.ht7.dao.BaseDao;
import com.qhit.gr3.cyh.ht7.util.HibernateSessionFactory;


public class BaseDaoImpl implements BaseDao {

	@Override
	public Object getObject(Class clazz, Integer id) {
		// TODO Auto-generated method stub
		Object object = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		object = session.get(clazz, id);
		ts.commit();
		session.close();
		return object;
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		session.save(object);
		ts.commit();

		session.close();
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		session.delete(object);
		ts.commit();
		session.close();
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		session.update(object);
		ts.commit();
		session.close();
	}

	@Override
	public List<Object> getAll(String hql) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();

		List<Object> list = session.createQuery(hql).list();
		ts.commit();
		session.close();
		return list;
	}

	@Override
	public List<Object[]> getMsgArray(String hql) {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = 0; i < hql.length(); i++) {
			String s=String.valueOf(hql.charAt(i));
			if("?".equals(s)) {
				count++;
			}
		}
		Session session=HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		
		List<Object[]> array=session.createQuery(hql).list();
		ts.commit();
		session.close();
		return array;
	}

}
