package com.yiidian.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色（多方）
 * @author http://www.yiidian.com
 *
 */
public class Role implements Serializable{

	private Integer id;
	private String name;
	
	//关联用户
	private Set<User> users = new HashSet<User>();
	
	
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
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
	
}
