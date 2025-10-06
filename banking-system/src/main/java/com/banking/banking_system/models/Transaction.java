package com.banking.banking_system.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private Double amount;
	private String fromAccount;
	private String toAccount;
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name  = "account_id")
	private Account account;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long id, String type, Double amount, String fromAccount, String toAccount, LocalDateTime date,
			Account account) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.date = date;
		this.account = account;
	}

	public Transaction(String type, Double amount, String fromAccount, String toAccount, LocalDateTime date,
			Account account) {
		super();
		this.type = type;
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.date = date;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
