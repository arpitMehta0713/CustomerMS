package com.cg.apps.task1.customerMgt.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.task1.customerMgt.entities.Customer;
import com.cg.apps.task1.customerMgt.exceptions.CustomerNotFoundException;

@Repository
public class CustomerDAOImpl implements ICustomerDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public Customer add(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer findByID(Long customerID) {
		Customer customer = entityManager.find(Customer.class, customerID);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer does not exist for ID: " + customerID);
		}
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		customer = entityManager.merge(customer);
		return customer;
	}

}
