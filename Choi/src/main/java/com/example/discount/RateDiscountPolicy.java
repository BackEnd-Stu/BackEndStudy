package com.example.discount;

import com.example.member.Grade;
import com.example.member.MemberDto;

public class RateDiscountPolicy implements DiscountPolicy{

	private int discountPercent = 10;

	@Override
	public int discount(MemberDto memberDto, int price) {
		if (memberDto.getGrade() == Grade.VIP) {
			return price * discountPercent / 100 ;
		} else {
			return 0;
		}

	}

}
