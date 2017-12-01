package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Role;
import com.yiidian.domain.User;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示多对多的映射
 * @author http://www.yiidian.com
 */
public class Demo {
	
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		User u1 = new User();
		u1.setUserName("小泽");
		
		User u2 = new User();
		u2.setUserName("小仓");
		
		Role r1 = new Role();
		r1.setRoleName("视觉总监");
		
		Role r2 = new Role();
		r2.setRoleName("动作指导");
		
		
		u1.getRoles().add(r1);
		r1.getUsers().add(u1);
		
		u2.getRoles().add(r2);
		r2.getUsers().add(u2);
		
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		tx.commit();
	}
	
}