package com.example.springstarterdemo.discount;

import com.example.springstarterdemo.member.Member;

public interface DiscountPolicy {


    /**
    *
    * @return 할인 금액
    *
    * */

    int discount(Member member, int price);



}
