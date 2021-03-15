package com.cg.apps.task1.itemMgt.dao;

import com.cg.apps.task1.itemMgt.entities.Item;

public interface IItemDAO {
	Item add(Item item);
    Item update(Item item);
    Item findByID(String itemID);
}
