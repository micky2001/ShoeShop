package com.sample.demo.entity;

import javax.persistence.Column;

//import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Productid")
	private int productId;
	
	@Column(name="productname")
	private String productName;
	
	@Column(name="Color")
	private String color;
	
	@Column(name="Size")
	private String size;
	
	@Column(name="Category")
	private String category;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Price")
	private double price;
	
	@Column(name="Sellerid")
	private int sellerId;
	
	@Column(name="imgurl")
	private String imgUrl;
	
	@Column(name="pdesc")
	private String pdesc;
	
	public Product() {
		
	}

	

	public Product(int productId, String productName, String color, String size, String category, String gender,
			double price, int sellerId, String imgUrl, String pdesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.color = color;
		this.size = size;
		this.category = category;
		this.gender = gender;
		this.price = price;
		this.sellerId = sellerId;
		this.imgUrl = imgUrl;
		this.pdesc = pdesc;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	
	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}



	public String getImgUrl() {
		return imgUrl;
	}



	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	

	public String getPdesc() {
		return pdesc;
	}



	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", color=" + color + ", size="
				+ size + ", category=" + category + ", gender=" + gender + ", price=" + price + ", sellerId=" + sellerId
				+ ", imgUrl=" + imgUrl + ", pdesc=" + pdesc + "]";
	}



	

	
	
	
	
}
