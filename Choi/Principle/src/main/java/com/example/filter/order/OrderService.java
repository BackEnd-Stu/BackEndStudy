package com.example.filter.order;

public interface OrderService {
	OrderDto createOrder(Long memberId, String itemName, int itemPrice);
}
