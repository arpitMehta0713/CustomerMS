package com.cg.apps.task1.customerMgt.dto;

public class CreateCustomerRequest {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CreateCustomerRequest(String name) {
		super();
		this.name = name;
	}
	
}
