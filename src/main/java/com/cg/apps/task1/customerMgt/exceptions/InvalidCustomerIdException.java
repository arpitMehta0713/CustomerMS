package com.cg.apps.task1.customerMgt.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
	public InvalidCustomerIdException(String msg) {
		super(msg);
	}
}
