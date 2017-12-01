package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yiidian.domain.Customer;

/**
 * hibernate的HelloWorld测试类
 * @author http://www.yiidian.com
 *
 */
public class Demo {

	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("老王");
		customer.setAge(40);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		//1.读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration();
		cfg.configure(); 
		
		//2.创建SessionFactory工厂
		SessionFactory factory = cfg.buildSessionFactory();
		
		//3.创建Session对象
		Session session = factory.openSession();
		
		//4.开启事务
		Transaction tx = session.beginTransaction();
		
		//5.执行添加操作
		session.save(customer);
		
		//6.提交事务
		tx.commit();
		
		//7.关闭资源
		session.close();
	}
}
