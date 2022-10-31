package com.example.springstarterdemo;

import com.example.springstarterdemo.member.Grade;
import com.example.springstarterdemo.member.Member;
import com.example.springstarterdemo.member.MemberService;
import com.example.springstarterdemo.member.MemberServiceImpl;
import com.example.springstarterdemo.order.Order;
import com.example.springstarterdemo.order.OrderService;
import com.example.springstarterdemo.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order  = " + order.toString());
        System.out.println("order.calculatorPrice = " + order.calculatePrice());


    }
}
