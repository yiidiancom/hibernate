package com.yiidian.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yiidian.domain.Card;
import com.yiidian.domain.Person;
import com.yiidian.utils.HibernateUtil;

/**
 * 演示Hibernate的一对一关系映射操作
 * 
 * @author http://www.yiidian.com
 * 
 */
public class Demo {

	/**
	 * 添加
	 */
	@Test
	public void test1(){
		Person p = new Person();
		p.setName("小苍");
		
		Card c = new Card();
		c.setName("1001");
		
		p.setCard(c);
		c.setPerson(p);
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(p);
		session.save(c);
		
		tx.commit();
		session.close();
	}

}
