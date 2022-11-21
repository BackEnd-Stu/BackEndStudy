package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.discount.DiscountPolicy;
import com.example.discount.FixDiscountPolicy;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.order.OrderService;
import com.example.order.OrderServiceImpl;
import com.example.repository.MemberRepository;
import com.example.repository.MemoryMemberRepository;

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
