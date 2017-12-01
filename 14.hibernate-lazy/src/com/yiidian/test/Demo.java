package com.yiidian.test;

import org.hibernate.Session;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.domain.Order;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示延迟加载的相关操作
 * 
 * @author http://www.yiidian.com
 * 
 */
public class Demo {

	@Test
	public void loadCustomer() {
		// 获取Session对象
		Session session = HibernateUtil.getSession();
		// 如果通过load方式加载Customer对象
		Customer customer = (Customer) session.load(Customer.class, 1);
		// 关闭session
		session.close();
	}

	@Test
	public void loadCustomer2() {
		// 获取Session对象
		Session session = HibernateUtil.getSession();
		// 如果通过load方式加载Customer对象
		Customer customer = (Customer) session.load(Customer.class, 1);
		customer.getOrders().size();
		// 关闭session
		session.close();
	}

	@Test
	public void loadOrder() {
		// 获取Session对象
		Session session = HibernateUtil.getSession();
		// 如果通过load方式加载Order对象
		Order order = (Order) session.get(Order.class, 1);

		// 获取Customer对象，因为此时的配置文件lazy是proxy，所以是代理对象
		Customer customer = order.getCustomer();
		// 关闭session
		session.close();
	}
	
	@Test
	public void loadOrder2() {
		// 获取Session对象
		Session session = HibernateUtil.getSession();
		// 如果通过load方式加载Order对象
		Order order = (Order) session.get(Order.class, 1);

		////获取Dept对象，因为此时的配置文件lazy是false，所以是实际对象
		Customer customer = order.getCustomer();
		// 关闭session
		session.close();
	}
}