package com.cg.apps.task1.itemMgt.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerMgt.entities.Customer;
import com.cg.apps.task1.customerMgt.service.ICustomerService;
import com.cg.apps.task1.itemMgt.entities.Item;
import com.cg.apps.task1.itemMgt.service.IItemService;

@Component
public class ItemMgtUI {
	@Autowired
	private IItemService service;
	@Autowired
	private ICustomerService custService;

	public void start() {
		Customer customer2 = custService.createCustomer("Abhishek");
		Item addedItem = service.create(17000.0, "Realme X smartphone");
		Item addedItem1 = service.create(25000.0, "Redmi K20 smartphone");
		Item fetchedItem = service.findByID(addedItem1.getId());
		Long customerFetched = customer2.getId();
		Item boughtItem = service.buyItem(addedItem.getId(), customerFetched);
		displayItemDetails(addedItem);
		displayItemDetails(fetchedItem);
		System.out.println("Item "+ boughtItem.getDescription()+" is bought by: "+ boughtItem.getBoughtBy().getName());
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
