package com.example.choi;

import com.example.discount.FixDiscountPolicy;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.order.OrderService;
import com.example.order.OrderServiceImpl;
import com.example.repository.MemoryMemberRepository;

public class AppConfig {
	public MemberService memberService() {
		return new MemberServiceImpl (new MemoryMemberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

	}
}
