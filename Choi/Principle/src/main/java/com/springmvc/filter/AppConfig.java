package com.springmvc.filter;

import com.springmvc.filter.repository.MemberRepository;
import com.springmvc.filter.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springmvc.filter.discount.DiscountPolicy;
import com.springmvc.filter.discount.FixDiscountPolicy;
import com.springmvc.filter.member.MemberService;
import com.springmvc.filter.member.MemberServiceImpl;
import com.springmvc.filter.order.OrderService;
import com.springmvc.filter.order.OrderServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
}
