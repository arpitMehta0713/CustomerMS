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
import com.cg.apps.task1.itemMgt.service.IItemService;

@Component
public class CustomerMgtUI {
	@Autowired
	private ICustomerService custService;
	@Autowired
	private IItemService itemService;

	public void start() {
		try {
			Customer customer2 = custService.createCustomer("Abhishek");
			Customer customer1 = custService.createCustomer("Arpit");
			Item addedItem = itemService.create(17000.0, "Realme X smartphone");
			Item addedItem1 = itemService.create(25000.0, "Redmi K20 smartphone");
			Long customer1Id = customer1.getId();
			Long customer2Id = customer2.getId();
			Item boughtItem = itemService.buyItem(addedItem.getId(), customer1Id);
			Item boughtItem1 = itemService.buyItem(addedItem1.getId(), customer2Id);
			System.out.println("Printing the items bought by " + customer1.getName());
			Customer customer1Fetched = custService.findByID(customer1Id);
			displayCustomerDetails(customer1Fetched);
			
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
		System.out.println("Printing details of items bought by " + customer.getName());
		Set<Item> itemsBought = customer.getBoughtItems();
		for (Item item : itemsBought) {
			displayItemDetails(item);
		}

	}

	public void displayItemDetails(Item item) {
		System.out.println("ID:" + item.getId() + "\nDescription:" + item.getDescription() + "\nPrice:"
				+ item.getPrice() + "\nAddedDate" + item.getAddedDate());
	}

}
