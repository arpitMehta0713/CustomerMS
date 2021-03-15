package com.cg.apps.task1.customerMgt.util;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerMgt.dto.CustomerDetails;
import com.cg.apps.task1.customerMgt.entities.Account;
import com.cg.apps.task1.customerMgt.entities.Customer;
import com.cg.apps.task1.itemMgt.entities.*;

@Component
public class CustomerUtil {
	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails custDetails = new CustomerDetails();
		custDetails.setId(customer.getId());
		custDetails.setName(customer.getName());
		Account account = customer.getAccount();
		custDetails.setAccountId(account.getAccountId());
		custDetails.setBalance(account.getBalance());
		custDetails.setAccountCreatedTime(account.getCreated());
		Set<Item> boughtItems = customer.getBoughtItems();
		Set<String> items = new HashSet<>();
		for (Item item : boughtItems) {
			items.add(item.getDescription());
		}
		custDetails.setDescriptions(items);
		return custDetails;
	}
}
