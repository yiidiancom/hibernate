package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Role;
import com.yiidian.domain.User;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示Hibernate的多对多关系映射操作
 * 
 * @author http://www.yiidian.com
 * 
 */
public class Demo {

	/**
	 * 添加操作
	 */
	@Test
	public void test1(){
		/**
		 * 需求：建立2个用户，2个角色
		 */
		User u1 = new User();
		u1.setName("小苍");
		
		User u2 = new User();
		u2.setName("小泽");
		
		Role r1 = new Role();
		r1.setName("超级管理员");
		
		Role r2 = new Role();
		r2.setName("普通管理员");
		
		//建立双向关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);
		
		u2.getRoles().add(r2);
		r2.getUsers().add(u2);
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		tx.commit();
		session.close();
	}

}
