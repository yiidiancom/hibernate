package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.domain.Order;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示一对多的映射
 * @author lenovo
 *
 */
public class Demo {

	
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Customer cust = new Customer();
		cust.setName("王五");
		session.save(cust);
	
		Order o1 = new Order();
		o1.setOrderno("201709001");
		
		Order o2 = new Order();
		o2.setOrderno("201709002");
		
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);
		
		session.save(cust);
		session.save(o1);
		session.save(o2);
		
		tx.commit();
	}
	
}