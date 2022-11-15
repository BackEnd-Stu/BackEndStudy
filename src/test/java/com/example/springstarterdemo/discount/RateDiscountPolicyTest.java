package com.example.springstarterdemo.discount;

import com.example.springstarterdemo.member.Grade;
import com.example.springstarterdemo.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("10% 할인이 적용되는가?")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);


        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("Non VIP면 할인 안되야함")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);


        assertThat(discount).isEqualTo(0);
    }

}