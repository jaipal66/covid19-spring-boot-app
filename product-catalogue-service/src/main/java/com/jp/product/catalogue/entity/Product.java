package com.jp.product.catalogue.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jp.product.catalogue.enums.Brand;
import com.jp.product.catalogue.enums.Color;
import com.jp.product.catalogue.enums.Size;

@Entity
public class Product {

	@Id
	private int productID;
	
	private String prodctName;
	@Enumerated
	private Color color=Color.BLACK;
	@Enumerated
	private Brand brand=Brand.FLYING_MACHINE;
	@Enumerated
	private Size size=Size.SMALL;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name="category_id",referencedColumnName="categoryID",nullable=false)
	private ProductCategory category;
	
	@ManyToOne
	@JoinColumn(name="suplier_id", referencedColumnName="suplierID")
	private Suplier suplier;
	
	@ManyToOne
	@JoinColumn(name="order_id",referencedColumnName="orderID")
	private Order order;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProdctName() {
		return prodctName;
	}

	public void setProdctName(String prodctName) {
		this.prodctName = prodctName;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Suplier getSuplier() {
		return suplier;
	}

	public void setSuplier(Suplier suplier) {
		this.suplier = suplier;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}	
}
