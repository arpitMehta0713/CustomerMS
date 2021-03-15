package com.cg.apps.task1.itemMgt.util;

import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerMgt.entities.Customer;
import com.cg.apps.task1.itemMgt.dto.ItemDetails;
import com.cg.apps.task1.itemMgt.entities.Item;

@Component
public class ItemUtil {
	public ItemDetails toDetails(Item item) {
		ItemDetails itemDetails = new ItemDetails();
		itemDetails.setId(item.getId());
		itemDetails.setAddedDate(item.getAddedDate());
		itemDetails.setDescription(item.getDescription());
		itemDetails.setPrice(item.getPrice());
		Customer customer = item.getBoughtBy();
		itemDetails.setCustId(customer.getId());
		itemDetails.setCustName(customer.getName());
		return itemDetails;
	}
}
