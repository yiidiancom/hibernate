package com.yiidian.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate开发的工具类
 * @author http://www.yiidian.com
 *
 */
public class HibernateUtil {

	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	
	//只需要执行1次
	static{
		cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
	}
	
	/**
	 * 让外部获取Session对象
	 */
	public static Session getSession(){
		return factory.openSession();
	}
}
