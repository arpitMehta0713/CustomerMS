package com.cg.apps.task1.customerMgt.dao;

import com.cg.apps.task1.customerMgt.entities.Customer;

public interface ICustomerDAO {
	Customer add(Customer customer);
    Customer findByID(Long customerID);
    Customer update(Customer customer);
}
