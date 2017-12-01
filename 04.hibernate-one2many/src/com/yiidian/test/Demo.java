package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.domain.Order;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示Hibernate的一对多关系映射操作
 * 
 * @author http://www.yiidian.com
 * 
 */
public class Demo {

	/**
	 * 保存操作
	 */
	@Test
	public void test1() {
		// 准备数据
		// 需求：1个客户 2张订单
		Customer cust = new Customer();
		cust.setName("小苍");
		cust.setGender("女");

		Order o1 = new Order();
		o1.setOrderno("201709070001");
		o1.setProductName("JavaWeb开发详解");

		Order o2 = new Order();
		o2.setOrderno("201709070002");
		o2.setProductName("Spring开发详解");

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		// 建立一对多双向关系
		cust.getOrders().add(o1);
		cust.getOrders().add(o2);
		o1.setCustomer(cust);
		o2.setCustomer(cust);

		session.save(cust);
		session.save(o1);
		session.save(o2);

		tx.commit();
		session.close();
	}

}
