package com.cg.apps.task1.customerMgt.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.task1.customerMgt.dto.AddAmountRequest;
import com.cg.apps.task1.customerMgt.dto.CustomerDetails;
import com.cg.apps.task1.customerMgt.dto.ItemsFetchRequest;
import com.cg.apps.task1.customerMgt.entities.Customer;
import com.cg.apps.task1.customerMgt.service.ICustomerService;
import com.cg.apps.task1.customerMgt.util.CustomerUtil;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private ICustomerService custService;
	@Autowired
	private CustomerUtil customerUtil;
	
	@GetMapping("/byid/{id}")
	public CustomerDetails fetchCustomer(@PathVariable("id") Long id) {
		Customer customer = custService.findByID(id);
		CustomerDetails customerDetails = customerUtil.toDetails(customer);
		return customerDetails;
	}
	
	@PutMapping("/addamount")
	public CustomerDetails addAmount(@RequestBody AddAmountRequest requestData) {
		Customer customer = custService.addAmount(requestData.getId(), requestData.getAmount());
		CustomerDetails customerDetails = customerUtil.toDetails(customer);
		return customerDetails;
	}

	@GetMapping("items")
	public Set<String> fetchItems(@RequestBody ItemsFetchRequest requestData) {
		Customer customer = custService.findByID(requestData.getCustId());
		CustomerDetails customerDetails = customerUtil.toDetails(customer);
		Set<String> itemsSet = customerDetails.getDescriptions();
		return itemsSet;
	}
}
