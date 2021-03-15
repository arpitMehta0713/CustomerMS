package com.cg.apps.task1.itemMgt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.apps.task1.itemMgt.exceptions.InvalidDescriptionException;
import com.cg.apps.task1.itemMgt.exceptions.InvalidPriceException;
import com.cg.apps.task1.itemMgt.exceptions.ItemNotFoundException;

@RestControllerAdvice
public class CentralizedItemsExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public String handleInvalidDescription(InvalidDescriptionException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public String handleInvalidPrice(InvalidPriceException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public String handleItemNotFound(ItemNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public String handleAllOther(Exception e) {
		return e.getMessage();
	}
}
