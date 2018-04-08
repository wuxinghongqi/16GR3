/**
 * 
 */
package com.qhit.lh.gr3.xhq.exam.common.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.qhit.lh.gr3.xhq.exam.common.utils.HibernateSessionFactory;

/**
 * @author admin
 * 2017年12月27日
 */
public class BaseDao {
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
}
