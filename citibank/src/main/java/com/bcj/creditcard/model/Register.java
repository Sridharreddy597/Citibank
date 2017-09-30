package com.bcj.creditcard.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Register {
	
	@Id @GeneratedValue
	private int id;
	private String userName;
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="creditcardId")	
	private CreditCard creditcard;
	
	private String  email;	
	private int customerId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public CreditCard getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(CreditCard creditcard) {
		this.creditcard = creditcard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", userName=" + userName + ", password=" + password + ", creditcard=" + creditcard
				+ ", email=" + email + ", customerId=" + customerId + "]";
	}
	

}
