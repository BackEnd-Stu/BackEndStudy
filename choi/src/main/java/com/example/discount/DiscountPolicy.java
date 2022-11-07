package com.example.discount;

import com.example.member.MemberDto;

public interface DiscountPolicy {
	int discount(MemberDto memberDto, int price);
}
