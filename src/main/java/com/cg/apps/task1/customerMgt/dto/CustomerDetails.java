package com.cg.apps.task1.customerMgt.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class CustomerDetails {
	private long id;
	private String name;
	private long accountId;
	private double balance;
	private LocalDateTime accountCreatedTime;
	private Set<String> descriptions;

	public Set<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<String> descriptions) {
		this.descriptions = descriptions;
	}

	public CustomerDetails() {

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
