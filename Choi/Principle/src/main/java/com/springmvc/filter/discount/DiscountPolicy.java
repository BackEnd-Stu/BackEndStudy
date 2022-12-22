package com.springmvc.filter.discount;

import com.springmvc.filter.member.MemberDto;

public interface DiscountPolicy {
	int discount(MemberDto memberDto, int price);
}
