package com.example.filter.discount;

import com.example.filter.member.MemberDto;

public interface DiscountPolicy {
	int discount(MemberDto memberDto, int price);
}
