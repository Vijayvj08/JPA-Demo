package com.banking.banking_system.models;

import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String accountNumber;
	
	@Column(nullable = false)
	private double balance;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	 @PrePersist
	    public void generateAccountNumber() {
	        if (this.accountNumber == null) {
	            this.accountNumber = "AC" + (10000000 + new Random().nextInt(90000000));
	        }
	    }

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long id, String accountNumber, double balance, User user) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
	}

	public Account(String accountNumber, double balance, User user) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
