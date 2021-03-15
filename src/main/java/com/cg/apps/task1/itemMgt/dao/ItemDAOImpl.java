package com.cg.apps.task1.itemMgt.dao;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.task1.itemMgt.entities.Item;
import com.cg.apps.task1.itemMgt.exceptions.InvalidIdException;
import com.cg.apps.task1.itemMgt.exceptions.ItemNotFoundException;

@Repository
class ItemDAOImpl implements IItemDAO {
	@Autowired
	private EntityManager entityManager;

	public static String generateItemId() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int generatedDigit = random.nextInt(9);
			builder.append(generatedDigit);
		}
		String itemId = builder.toString();
		return "ITEM-" + itemId;
	}

	@Override
	public Item add(Item item) {
		item.setId(generateItemId());
		entityManager.persist(item);
		return item;
	}

	@Override
	public Item update(Item item) {
		item = entityManager.merge(item);
		return item;
	}

	@Override
	public Item findByID(String itemID) {
		Item item = entityManager.find(Item.class, itemID);
		if (item == null) {
			throw new ItemNotFoundException("The requested item for ID " + itemID + " is not found");
		}
		return item;
	}

}
