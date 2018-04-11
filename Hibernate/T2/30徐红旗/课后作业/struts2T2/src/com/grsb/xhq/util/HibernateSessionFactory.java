package com.grsb.xhq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory sessionfactory;
	private static Configuration configuration;
	static {
		//ʵ����Configuration����Ĭ�϶�ȡsrcĿ¼�µ�hibernate.cfg.xml�����ļ�������configure();��ָ���ļ����ƺ�·��
		configuration = new Configuration().configure("hibernate.cfg.xml");
		//�������config�����Ѿ���������Hibernate�����ڵĲ�����
		//ͨ��Configurationʵ����buildSessionFactory()�������Թ���һ��Ωһ��SessionFactory��
		sessionfactory = configuration.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session=sessionfactory.openSession();
		return session;
	}
}
