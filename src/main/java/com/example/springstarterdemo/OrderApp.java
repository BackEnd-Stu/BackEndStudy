package com.example.springstarterdemo;

import com.example.springstarterdemo.member.Grade;
import com.example.springstarterdemo.member.Member;
import com.example.springstarterdemo.member.MemberService;
import com.example.springstarterdemo.member.MemberServiceImpl;
import com.example.springstarterdemo.order.Order;
import com.example.springstarterdemo.order.OrderService;
import com.example.springstarterdemo.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order  = " + order.toString());
        System.out.println("order.calculatorPrice = " + order.calculatePrice());


    }
}
