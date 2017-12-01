package com.yiidian.test;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示延迟加载的相关操作
 * 
 * @author http://www.yiidian.com
 * 
 */
public class Demo {

	@Test
	public void test1() {
		Session session = HibernateUtil.getSession();
		Customer customer = (Customer) session.load(Customer.class, 1);
		customer.getOrders().size();
		session.close();
	}

	@Test
	public void test2() {
		Session session = HibernateUtil.getSession();
		List<Customer> results = session.createQuery(
				"From Customer c where c.id in (1,2,3,4)").list();
		// 这里的四个 id 是我数据库中已经准备好的数据
		Customer c0 = (Customer) results.get(0);
		c0.getOrders().size();
		session.close();
	}

}