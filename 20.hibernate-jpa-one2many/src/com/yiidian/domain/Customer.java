package com.yiidian.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 客户（一方）
 * @author http://www.yiidian.com
 * 
 */
@Entity
@Table(name="t_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private String gender;
	
	@Transient // 临时字段，不反映到数据库中
	private Boolean isMarried;
	public Boolean getIsMarried() {
		return isMarried;
	}
	
	//关联订单
	@OneToMany(targetEntity=Order.class,mappedBy="customer")
	private Set<Order> orders = new HashSet<Order>();
	
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
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
