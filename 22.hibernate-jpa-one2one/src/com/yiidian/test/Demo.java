package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Card;
import com.yiidian.domain.Person;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示一对一的映射
 * @author lenovo
 *
 */
public class Demo {
	
	@Test
	public void test1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		Person p = new Person();
		p.setName("老王");
		
		Card c = new Card();
		c.setCardno("44333222");
		
		p.setCard(c);
		c.setPerson(p);
		
		session.save(p);
		session.save(c);
		
		tx.commit();
	}
	
}