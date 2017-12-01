package com.yiidian.domain;

import java.io.Serializable;
/**
 * 身份证类
 * @author http://www.yiidian.com
 *
 */
public class Card implements Serializable{
	private Integer id;
	private String name;
	//关联公民
	private Person person;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
