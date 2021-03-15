package com.cg.apps.task1.customerMgt.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
