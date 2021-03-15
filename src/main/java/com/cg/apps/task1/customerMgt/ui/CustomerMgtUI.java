package com.cg.apps.task1.customerMgt.ui;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerMgt.entities.Customer;
import com.cg.apps.task1.customerMgt.exceptions.CustomerNotFoundException;
import com.cg.apps.task1.customerMgt.exceptions.InvalidAmountException;
import com.cg.apps.task1.customerMgt.exceptions.InvalidCustomerIdException;
import com.cg.apps.task1.customerMgt.exceptions.InvalidNameException;
import com.cg.apps.task1.customerMgt.service.CustomerServiceImpl;
import com.cg.apps.task1.customerMgt.service.ICustomerService;
import com.cg.apps.task1.itemMgt.entities.Item;

@Component
public class CustomerMgtUI {
	@Autowired
	private ICustomerService service;

	public void start() {
		try {
			Customer customer = service.createCustomer("Arpit");
			Long customerFetched = customer.getId();
			displayCustomerDetails(customer);
			Set<Item> itemsBought = service.itemsBoughtByCustomer(customerFetched);
			for (Item i : itemsBought) {
				displayItemDetails(i);
			}
			System.out.println("Printing customer bought item details");
			Set<Item> itemsBought2 = customer.getBoughtItems();
			for (Item i : itemsBought2) {
				displayItemDetails(i);
			}
		} catch (InvalidCustomerIdException e) {
			System.out.println(e.getMessage());
		} catch (InvalidNameException e) {
			System.out.println(e.getMessage());
		} catch (InvalidAmountException e) {
			System.out.println(e.getMessage());
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

	public void displayCustomerDetails(Customer customer) {
		System.out.println("Id:" + customer.getId() + "\nName:" + customer.getName() + "\nAccountBalance:"
				+ customer.getAccount().getBalance());

	}

	public void displayItemDetails(Item item) {
		System.out.println("ID:" + item.getId() + "\nDescription:" + item.getDescription() + "\nPrice:"
				+ item.getPrice() + "\nAddedDate" + item.getAddedDate());
	}

}
