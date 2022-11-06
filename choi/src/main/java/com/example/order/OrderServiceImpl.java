package com.example.order;

import com.example.discount.DiscountPolicy;
import com.example.discount.FixDiscountPolicy;
import com.example.discount.RateDiscountPolicy;
import com.example.member.MemberDto;
import com.example.repository.MemberRepository;
import com.example.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

	private DiscountPolicy discountPolicy;

	public OrderServiceImpl(MemoryMemberRepository memoryMemberRepository, FixDiscountPolicy fixDiscountPolicy) {
	}

	@Override
	public OrderDto createOrder(Long memberId, String itemName, int itemPrice) {
		MemberDto memberDto = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(memberDto, itemPrice);
		return new OrderDto(memberId, itemName, itemPrice, discountPrice);
	}
}
