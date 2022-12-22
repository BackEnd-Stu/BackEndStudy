package com.springmvc.filter.discount;

import com.springmvc.filter.member.Grade;
import com.springmvc.filter.member.MemberDto;
import org.springframework.stereotype.Component;

@Component
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
