package com.yiidian.domain;
/**
 * 订单（多方）
 * @author http://www.yiidian.com
 *
 */
public class Order {

	private Integer id;
	private String orderno;
	private String productName;
	
	//关联客户
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Order(String orderno, String productName) {
		super();
		this.orderno = orderno;
		this.productName = productName;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderno=" + orderno + ", productName="
				+ productName + "]";
	}

}
