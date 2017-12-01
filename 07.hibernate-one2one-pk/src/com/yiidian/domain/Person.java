package com.yiidian.domain;

import java.io.Serializable;
/**
 * 公民类
 * @author http://www.yiidian.com
 *
 */
public class Person implements Serializable{
	private Integer id;
	private String name;
	
	//关联身份证
	private Card card;

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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
}
