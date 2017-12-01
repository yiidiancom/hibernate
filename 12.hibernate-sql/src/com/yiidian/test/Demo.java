package com.yiidian.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Order;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示本地SQL的查询（比较少用）
 * 
 * @author http://www.yiidian.com
 * 
 */
public class Demo {

	// 以对象数组封装
	@Test
	public void test1() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		SQLQuery sqlQuery = session.createSQLQuery("select * from t_order");
		List<Object[]> list = sqlQuery.list();
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object + "\t");
			}
			System.out.println();
		}

		tx.commit();
		session.close();
	}

	// 以JavaBean对象封装
	@Test
	public void test2() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		SQLQuery sqlQuery = session.createSQLQuery("select * from t_order");
		sqlQuery.addEntity(Order.class);
		List<Order> list = sqlQuery.list();
		for (Order order : list) {
			System.out.println(order);
		}

		tx.commit();
		session.close();
	}

}