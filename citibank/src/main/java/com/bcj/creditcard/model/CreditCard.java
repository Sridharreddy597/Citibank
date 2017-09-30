package com.bcj.creditcard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CreditCard {
	
	
			@Id @GeneratedValue
		private int id;
		private String cardNumber;
		private String cvv;
		private String expiryDate;
		private  float creditLimit;
		private String   status ="inactive";
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}


		@OneToOne
		@JoinColumn(name="CustomerId")		
		private Customer customer;
		
		
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
		public String getCvv() {
			return cvv;
		}
		public void setCvv(String cvv) {
			this.cvv = cvv;
		}
		public String getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(String expiryDate2) {
			this.expiryDate = expiryDate2;
		}
		
		public float getCreditLimit() {
			return creditLimit;
		}
		public void setCreditLimit(float creditLimit) {
			this.creditLimit = creditLimit;
		}
		
		
		@Override
		public String toString() {
			return "CreditCard [id=" + id + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", expiryDate=" + expiryDate
					+ ", creditLimit=" + creditLimit + ", customer=" + customer + "]";
		}
		
		
		
		
		
		

}
