package com.sample.demo.entity;

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
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Customerid")
	private int customerId;
	
	@Column(name="custname")
	private String custName;
	
	@Column(name="Address")
    private String address;
	
	@Column(name="gender")
    private String gender;
	
	@Column(name="custemail")
    private String custEmail;
	
	@Column(name="custphone")
    private String custPhone;
	
	@Column(name="walletbalance")
    private double walletBalance;
    
    public Customer() {
    	
    }
    
    public Customer(int customerId, String custName, String address, String gender, String custEmail, String custPhone,
			double walletBalance) {
		super();
		this.customerId = customerId;
		this.custName = custName;
		this.address = address;
		this.gender = gender;
		this.custEmail = custEmail;
		this.custPhone = custPhone;
		this.walletBalance = walletBalance;
	}

	//-------------------------Getters & Setters------------------------
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCustEmail() {
		return custEmail;
	}
	
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	public String getCustPhone() {
		return custPhone;
	}
	
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	public double getWalletBalance() {
		return walletBalance;
	}
	
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
	
	//------------------To String --------------------
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custName=" + custName + ", address=" + address + ", gender="
				+ gender + ", custEmail=" + custEmail + ", custPhone=" + custPhone + ", walletBalance=" + walletBalance
				+ "]";
	}

		
	

}
