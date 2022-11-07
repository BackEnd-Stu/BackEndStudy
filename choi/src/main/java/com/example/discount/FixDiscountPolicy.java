package com.example.discount;

import com.example.member.Grade;
import com.example.member.MemberDto;

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
