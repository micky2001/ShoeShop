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
@Table(name="users")
public class Users {
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
	
	@Column(name="username")
    private String userName;
    
    @Column(name="passcode")
    private String password;
    
    @Column(name="usertype")
    private String userType;
    
    public Users() {
    	
    }
    
    public Users(int userId, String userName, String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType="
				+ userType + "]";
	}

	

	
    
    
}
