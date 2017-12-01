package com.yiidian.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户（一方）
 * @author http://www.yiidian.com
 *
 */
public class Customer {
	private Integer id;
	private String name;
	private String gender;
	
	//关联订单
	private Set<Order> orders = new HashSet<Order>();
	
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
