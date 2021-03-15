package com.cg.apps.task1.customerMgt.dto;

import java.time.LocalDateTime;

public class CustomerDetails {
	private long id;
	private String name;
	private long accountId;
	private double balance;
	private LocalDateTime accountCreatedTime;

	public CustomerDetails(long id, String name, long accountId, double balance, LocalDateTime accountCreatedTime) {
		this.id = id;
		this.name = name;
		this.accountId = accountId;
		this.balance = balance;
		this.accountCreatedTime = accountCreatedTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getAccountCreatedTime() {
		return accountCreatedTime;
	}

	public void setAccountCreatedTime(LocalDateTime accountCreatedTime) {
		this.accountCreatedTime = accountCreatedTime;
	}
}
