package com.cg.apps.task1.itemMgt.dto;

public class BuyItemRequest {
	private String itemId;
	private Long custId;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public BuyItemRequest() {

	}
}
