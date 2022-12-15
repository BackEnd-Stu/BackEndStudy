package com.example.filter.discount;

import com.example.filter.member.Grade;
import com.example.filter.member.MemberDto;

public class FixDiscountPolicy implements DiscountPolicy{

	private int discountFixAmount = 1000;

	@Override
	public int discount(MemberDto memberDto, int price) {
		if (memberDto.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
}
