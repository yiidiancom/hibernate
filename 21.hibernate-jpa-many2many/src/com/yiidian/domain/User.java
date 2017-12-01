package com.yiidian.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * 用户（多方）
 * @author http://www.yiidian.com
 */
@Entity
@Table(name="t_user")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="user_name")
	private String userName;
	
	//关联角色
	@ManyToMany(targetEntity=User.class)
	//@JoinTable: 用于映射中间表
	//joinColumns: 当前方在中间表的外键字段名称
	//inverseJoinColumns：对方在中间表的外键字段名称
	@JoinTable(
			name="t_user_role",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<Role>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
