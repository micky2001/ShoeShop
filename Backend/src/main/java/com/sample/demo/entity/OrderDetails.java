package com.sample.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
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
@Table(name="orderdetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderid")
	private int orderId;
	
	@Column(name="customerid")
	private int customerId;

	
	@Column(name="orderstatus")
	private String orderStatus;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="totalamount")
    private double totalAmount;
	
    public OrderDetails() {
    	
    }
    
	public OrderDetails(int orderId, int customerId, String orderStatus, int quantity, double totalAmount) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		//this.productId = productId;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", customerId=" + customerId + ", orderStatus=" + orderStatus
				+ ", quantity=" + quantity + ", totalAmount=" + totalAmount + "]";
	}

	

	
	
    
}
