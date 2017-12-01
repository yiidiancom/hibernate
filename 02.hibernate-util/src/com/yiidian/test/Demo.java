package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.utils.HibernateUtil;

/**
 * @author http://www.yiidian.com
 */
public class Demo {

	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("老王2");
		customer.setAge(40);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		//从工具类获取Session对象
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(customer);
		
		tx.commit();
		
		session.close();
	}
}
