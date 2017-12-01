package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Customer;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示Session接口进行CRUD
 * @author http://www.yiidian.com
 *
 */
public class Demo {


	/**
	 *save(Object obj) : 保存对象
	 */
	@Test
	public void test1(){
		Customer customer = new Customer();
		customer.setName("老王3");
		customer.setAge(40);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		Session session = HibernateUtil.getSession();
		
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//执行添加操作
		session.save(customer);
		
		//提交事务
		tx.commit();
		
		//关闭资源
		session.close();
	}
	
	/**
	 *update(Object obj)： 更新对象
	 */
	@Test
	public void test2(){
		Customer customer = new Customer();
		//给Customer的id赋值，才可以更新
		customer.setId(6);
		customer.setName("老王44444");
		customer.setAge(45);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		Session session = HibernateUtil.getSession();
		
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//执行添加操作
		session.update(customer);
		
		//提交事务
		tx.commit();
		
		//关闭资源
		session.close();
	}
	
	/**
	 *saveOrUpdate(Object obj): 添加或修改对象
	 */
	@Test
	public void test3(){
		Customer customer = new Customer();
		//给Customer的id赋值，才可以更新
		customer.setId(6);
		customer.setName("老王666");
		customer.setAge(45);
		customer.setGender("男");
		customer.setLevel("VIP客户");
		
		Session session = HibernateUtil.getSession();
		
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//执行添加操作
		session.saveOrUpdate(customer);
		
		//提交事务
		tx.commit();
		
		//关闭资源
		session.close();
	}
	
	/**
	 *delete(Object obj): 删除对象
	 */
	@Test
	public void test4(){
		
		Session session = HibernateUtil.getSession();
		
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//执行添加操作
		Customer customer = new Customer();
		customer.setId(7);
		session.delete(customer);
		
		//提交事务
		tx.commit();
		
		//关闭资源
		session.close();
	}
	
	/**
	 *get(Class clz,Serialize id): 获取对象
	 *load(Class clz,Serialize id): 获取对象 
	 */
	@Test
	public void test5(){
		
		Session session = HibernateUtil.getSession();
		
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//执行添加操作
		//Customer cust = session.get(Customer.class, 6);
		Customer cust = session.load(Customer.class, 6);
		System.out.println(cust);
		
		//提交事务
		tx.commit();
		
		//关闭资源
		session.close();
	}
}
