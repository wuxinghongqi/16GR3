package com.qhit.lh.gr3.xhq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory sessionfactory;
	private static Configuration configuration;
	static {
		//实例化Configuration对象，默认读取src目录下的hibernate.cfg.xml配置文件或者在configure();中指明文件名称和路径
		configuration = new Configuration().configure("hibernate.cfg.xml");
		//现在这个config对象，已经包括所有Hibernate运行期的参数，
		//通过Configuration实例的buildSessionFactory()方法可以构建一个惟一的SessionFactory：
		sessionfactory = configuration.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session=sessionfactory.openSession();
		return session;
	}
}
