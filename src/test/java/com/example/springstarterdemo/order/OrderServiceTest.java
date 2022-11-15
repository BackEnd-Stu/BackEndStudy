package com.example.springstarterdemo.order;

import com.example.springstarterdemo.AppConfig;
import com.example.springstarterdemo.member.Grade;
import com.example.springstarterdemo.member.Member;
import com.example.springstarterdemo.member.MemberService;
import com.example.springstarterdemo.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){

        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);


        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }

}
