package com.cg.apps.task1.customerMgt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.apps.task1.customerMgt.exceptions.CustomerNotFoundException;
import com.cg.apps.task1.customerMgt.exceptions.InvalidAmountException;
import com.cg.apps.task1.customerMgt.exceptions.InvalidCustomerIdException;
import com.cg.apps.task1.customerMgt.exceptions.InvalidNameException;
import com.cg.apps.task1.itemMgt.exceptions.InvalidDescriptionException;
import com.cg.apps.task1.itemMgt.exceptions.InvalidPriceException;
import com.cg.apps.task1.itemMgt.exceptions.ItemNotFoundException;

@RestControllerAdvice
class CentralizedCustomerExceptionHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public String handleCustomerNotFound(CustomerNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public String handleInvalidAmount(InvalidAmountException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public String handleInvalidId(InvalidCustomerIdException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public String handleInvalidName(InvalidNameException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public String handleAllOther(Exception e) {
		return e.getMessage();
	}
}
