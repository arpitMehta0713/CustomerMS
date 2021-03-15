package com.cg.apps.task1.itemMgt.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.task1.customerMgt.dao.ICustomerDAO;
import com.cg.apps.task1.customerMgt.entities.Customer;
import com.cg.apps.task1.itemMgt.dao.IItemDAO;
import com.cg.apps.task1.itemMgt.entities.Item;
import com.cg.apps.task1.itemMgt.exceptions.InvalidDescriptionException;
import com.cg.apps.task1.itemMgt.exceptions.InvalidIdException;
import com.cg.apps.task1.itemMgt.exceptions.InvalidPriceException;

@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private IItemDAO itemDao;
	@Autowired
	private ICustomerDAO custDao;
	@Transactional
	@Override
	public Item create(Double price, String description) {
		validatePrice(price);
		validateDescription(description);
		LocalDateTime addedTime = LocalDateTime.now();
		Item item = new Item(price, description, addedTime);
		itemDao.add(item);
		return item;
	}

	@Override
	public Item findByID(String itemID) {
		validateItemId(itemID);
		Item item = itemDao.findByID(itemID);
		return item;
	}

	@Transactional
	@Override
	public Item buyItem(String itemID, Long customerID) {
		validateItemId(itemID);
		validateCustomerId(customerID);
		Item item = itemDao.findByID(itemID);
		Customer customer = custDao.findByID(customerID);
		item.setBoughtBy(customer);
		Set<Item> existingItems = customer.getBoughtItems();
		if (existingItems == null) {
			existingItems = new HashSet<>();
			customer.setBoughtItems(existingItems);
		}
		existingItems.add(item);
		customer.setBoughtItems(existingItems);
		itemDao.update(item);
		custDao.update(customer);
		return item;
	}

	public void validateItemId(String itemId) {
		if (itemId == null || itemId.isEmpty() || itemId.trim().isEmpty()) {
			throw new InvalidIdException("Item ID cannot be null");
		}
	}

	public void validatePrice(Double price) {
		if (price <= 0) {
			throw new InvalidPriceException("Price cannot be less than or equal to zero" + price);
		}
	}

	public void validateDescription(String description) {
		if (description == null || description.isEmpty() || description.trim().isEmpty()) {
			throw new InvalidDescriptionException("Item Description cannot be null");
		}
	}

	public void validateCustomerId(Long id) {
		if (id == null) {
			throw new InvalidIdException("The entered ID " + id + " is invalid");
		}
	}
}