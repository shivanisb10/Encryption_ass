package com.psl.MyApp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Embeddable
@Entity
@Table(name="Products")
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	String Productid;
	
	@Column(name="Productname")
	String Productname;
	@Column(name="price")
	float price;
	@Column(name="quantity")
	int quantity;
	@Column(name="brand")
	String brand;
	@Column(name="size")
	@Enumerated(EnumType.STRING)
	Size size;
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	Category category;
	
	public String getProductname() {
		return Productname;
	}
	public Products() {
		// TODO Auto-generated constructor stub
	}
	public void setProductname(String Productname) {
		this.Productname = Productname;
	}
	public Products(String productname, float price, int quantity, String brand, Size size, Category category,
			String productid) {
		super();
		Productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.size = size;
		this.category = category;
		Productid = productid;
	}
	public String getProductid() {
		return Productid;
	}
	public void setProductid(String productid) {
		Productid = productid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
