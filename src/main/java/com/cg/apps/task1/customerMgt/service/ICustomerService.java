package com.cg.apps.task1.customerMgt.service;

import java.util.Set;

import com.cg.apps.task1.customerMgt.entities.Customer;
import com.cg.apps.task1.itemMgt.entities.*;
public interface ICustomerService {
	Customer findByID(Long customerID);

	Customer createCustomer(String name);

	Customer addAmount(Long customerId, double amount);

	Set<Item> itemsBoughtByCustomer(Long customerID);
}
