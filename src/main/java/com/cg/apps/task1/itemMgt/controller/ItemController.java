package com.cg.apps.task1.itemMgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.task1.itemMgt.dto.BuyItemRequest;
import com.cg.apps.task1.itemMgt.dto.ItemDetails;
import com.cg.apps.task1.itemMgt.entities.Item;
import com.cg.apps.task1.itemMgt.service.IItemService;
import com.cg.apps.task1.itemMgt.util.ItemUtil;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private IItemService itemService;
	@Autowired
	private ItemUtil itemUtil;

	@GetMapping("/id/{id}")
	public ItemDetails fetchItem(@PathVariable("id") String id) {
		Item item = itemService.findByID(id);
		ItemDetails itemDetails = itemUtil.toDetails(item);
		return itemDetails;
	}

	@PutMapping("/buy")
	public ItemDetails buyItem(@RequestBody BuyItemRequest requestData) {
		Item item = itemService.buyItem(requestData.getItemId(), requestData.getCustId());
		ItemDetails itemDetails = itemUtil.toDetails(item);
		return itemDetails;
	}
}
