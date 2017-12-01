package com.yiidian.test;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示二级缓存的作用
 * 
 * @author http://www.yiidian.com
 * 
 */
public class Demo {

	// 演示二级缓存
	@Test
	public void test1() {

		Session session = HibernateUtil.getSession();

		// 第1次操作
		Customer cust = session.get(Customer.class, 1);
		System.out.println(cust.getName());

		// 关闭session
		session.close();

		// 第2次操作
		session = HibernateUtil.getSession();
		cust = session.get(Customer.class, 1);
		System.out.println(cust.getName());

		session.close();

	}

	// 演示查询缓存
	@Test
	public void test2() {

		Session session = HibernateUtil.getSession();

		Query q = session.createQuery("select id,name from Customer");
		q.setCacheable(true);
		q.list();
		session.close();
		
		session = HibernateUtil.getSession();
		q = session.createQuery("select id,name from Customer");
		q.setCacheable(true);
		q.list();
		session.close();

	}

}