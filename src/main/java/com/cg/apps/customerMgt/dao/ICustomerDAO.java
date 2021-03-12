package com.cg.apps.customerMgt.dao;

import com.cg.apps.customerMgt.entities.Customer;

public interface ICustomerDAO {
	Customer add(Customer customer);
    Customer findByID(Long customerID);
    Customer update(Customer customer);
}
