package com.example.springstarterdemo;

import com.example.springstarterdemo.discount.DiscountPolicy;
import com.example.springstarterdemo.discount.FixDiscountPolicy;
import com.example.springstarterdemo.discount.RateDiscountPolicy;
import com.example.springstarterdemo.member.MemberRepository;
import com.example.springstarterdemo.member.MemberService;
import com.example.springstarterdemo.member.MemberServiceImpl;
import com.example.springstarterdemo.member.MemoryMemberRepository;
import com.example.springstarterdemo.order.OrderService;
import com.example.springstarterdemo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
