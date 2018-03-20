package com.wolverine.ssm.model;

public class ItemsQueryVo {
	/* 商品的信息类 */
	private Items items;
	/* 商品的扩展类 */
	private ItemsCustomer itemsCustomer;

	public ItemsCustomer getItemsCustomer() {
		return itemsCustomer;
	}

	public void setItemsCustomer(ItemsCustomer itemsCustomer) {
		this.itemsCustomer = itemsCustomer;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
}
