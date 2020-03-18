package com.psl.MyApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
@IdClass(value = CartId.class)
public class Cart implements Serializable{
	@Id
	String userid;
	@Id
	@OneToOne
	@JoinColumn(name = "productid")
    Products productid;
	int quantity;
	
	public Cart()
	{
		
	}
	public Cart(String userid,Products productid, int quantity) {
		super();
		this.productid = productid;
		this.quantity = quantity;
		
		this.userid=userid;
	}
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Products getProductid() {
		return productid;
	}
	public void setProductid(Products productid) {
		this.productid = productid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
