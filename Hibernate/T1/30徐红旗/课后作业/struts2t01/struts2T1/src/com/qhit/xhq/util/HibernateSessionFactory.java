package com.qhit.xhq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory sessionfactory;
	private static Configuration configuration;
	static {
		configuration = new Configuration().configure("hibernate.cfg.xml");
		sessionfactory = configuration.buildSessionFactory();
	}

	public static Session getSession() {
		Session session = sessionfactory.openSession();
		return session;
	}
}
