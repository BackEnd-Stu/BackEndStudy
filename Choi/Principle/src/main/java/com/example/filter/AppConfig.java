package com.example.filter;

import com.example.filter.repository.MemberRepository;
import com.example.filter.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filter.discount.DiscountPolicy;
import com.example.filter.discount.FixDiscountPolicy;
import com.example.filter.member.MemberService;
import com.example.filter.member.MemberServiceImpl;
import com.example.filter.order.OrderService;
import com.example.filter.order.OrderServiceImpl;

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
