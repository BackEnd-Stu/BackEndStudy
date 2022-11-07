package com.example.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.member.Grade;
import com.example.member.MemberDto;

public class RateDiscountPolicyTest {
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	void vip_10() {
		MemberDto memberDto = new MemberDto (1L, "memberVIP", Grade.VIP);
		int discount = discountPolicy.discount(memberDto, 10000);
		assertThat(discount).isEqualTo(1000);
	}

	@Test
	void vix_x() {
		MemberDto memberDto = new MemberDto (2L, "memberBasic", Grade.BASIC);
		int discount = discountPolicy.discount(memberDto, 10000);
		assertThat(discount).isEqualTo(0);
	}
}
