package com.yiidian.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.domain.Order;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示基本对象的查询
 * @author http://www.yiidian.com
 *
 */
public class Demo {

	/**
	 * get()方法: 查询一个对象
	 */
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.get(Customer.class,1);
		Set<Order> orders = cust.getOrders();
		System.out.println(cust.getName()+"的订单：");
		for (Order order : orders) {
			System.out.println(order.getOrderno());
		}
		
		tx.commit();
		session.close();
	}
	
	/**
	 * load()方法: 查询一个对象
	 */
	@Test
	public void test2(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = session.load(Customer.class,1);
		Set<Order> orders = cust.getOrders();
		System.out.println(cust.getName()+"的订单：");
		for (Order order : orders) {
			System.out.println(order.getOrderno());
		}
		
		tx.commit();
		session.close();
	}
}
