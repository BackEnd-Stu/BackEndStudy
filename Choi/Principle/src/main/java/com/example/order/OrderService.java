package com.example.order;

public interface OrderService {
	OrderDto createOrder(Long memberId, String itemName, int itemPrice);
}
