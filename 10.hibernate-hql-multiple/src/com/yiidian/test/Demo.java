package com.yiidian.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.utils.HibernateUtil;

/**
 * 演示HQL的查询（多表查询）
 *    1）内连接查询
 *    2）左连接查询
 *    3）右连接查询
 * @author http://www.yiidian.com
 *
 */
public class Demo {

	/**
	 * 内连接查询
	 * 效果：只会显示满足条件的数据
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Customer c inner join c.orders o");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 左连接查询
	 * 效果：左边的数据全部显示
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Customer c left join c.orders o");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 右连接查询
	 * 效果：右边的数据全部显示
	 */
	@Test
	public void test3(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//需求：显示客户名称和订单产品名称
		Query query = session.createQuery("select c.name,o.productName from Order o right join o.customer c");
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		
		
		tx.commit();
		session.close();
	}
	
	
}
