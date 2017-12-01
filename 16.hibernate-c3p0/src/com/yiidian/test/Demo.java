package com.yiidian.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.yiidian.utils.HibernateUtil;

/**
 * 演示连接池的整合
 * @author http://www.yiidian.com
 *
 */
public class Demo {

	@Test
	public void test1(){
		
		Session session = HibernateUtil.getSession();
		
		session.doWork(new Work(){

			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println(connection);
			}
		});
		
		
		session.close();
		
	}
	
	
}