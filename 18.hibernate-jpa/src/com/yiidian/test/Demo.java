package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示JPA的入门开发
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
		cust.setGender("男");
		session.save(cust);
		
		tx.commit();
	}
	
}