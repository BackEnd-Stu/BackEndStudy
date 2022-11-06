package com.example.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.member.Grade;
import com.example.member.MemberDto;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;

public class OrderServiceTest {
//	MemberService memberService = new MemberServiceImpl();
//	OrderService orderService = new OrderServiceImpl();

	@Test
	void createOrder() {
		long memberId = 1L;
		MemberDto memberDto = new MemberDto (memberId, "memberOne", Grade.VIP);
		memberService.join(memberDto);

		OrderDto orderDto = orderService.createOrder(memberId, "album", 20000);
		Assertions.assertThat(orderDto.getDiscountPrice()).isEqualTo(1000);
	}
}
