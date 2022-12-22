package com.springmvc.filter.order;

public class OrderDto {
	private Long memberId;
	 private String itemName;
	 private int itemPrice;
	 private int discountPrice;
	@Override
	public String toString() {
		return "OrderDto [memberId=" + memberId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", discountPrice=" + discountPrice + "]";
	}
	public OrderDto(Long memberId, String itemName, int itemPrice, int discountPrice) {
		super();
		this.memberId = memberId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
}
