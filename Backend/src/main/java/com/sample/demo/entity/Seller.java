package com.sample.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller")
public class Seller {
	
	@Id
	@Column(name="Sellerid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;
	
	@Column(name="sName")
	private String sname;
	
	@Column(name="semail")
	private String semail;
	
	@Column(name="sphone")
	private String sphone;
	
	public Seller() {
		
	}

	public Seller(int sellerId,String sname, String semail, String sphone) {
		super();
		this.sellerId = sellerId;
		this.sname = sname;
		this.semail = semail;
		this.sphone = sphone;
	}

	/**
	 * @return the sellerId
	 */
	public int getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return the semail
	 */
	public String getSemail() {
		return semail;
	}

	/**
	 * @param semail the semail to set
	 */
	public void setSemail(String semail) {
		this.semail = semail;
	}

	/**
	 * @return the sphone
	 */
	public String getSphone() {
		return sphone;
	}

	/**
	 * @param sphone the sphone to set
	 */
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sname=" + sname + ", semail=" + semail + ", sphone=" + sphone + "]";
	}

	
	

}
