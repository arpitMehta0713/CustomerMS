package com.cg.apps.task1.itemMgt.service;

import com.cg.apps.task1.itemMgt.entities.Item;

public interface IItemService {
	Item create(Double price, String description);

	Item findByID(String itemID);

	Item buyItem(String itemID, Long customerID);
}
