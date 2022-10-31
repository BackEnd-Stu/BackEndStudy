package com.example.springstarterdemo.order;

import com.example.springstarterdemo.discount.DiscountPolicy;
import com.example.springstarterdemo.discount.FixDiscountPolicy;
import com.example.springstarterdemo.member.Member;
import com.example.springstarterdemo.member.MemberRepository;
import com.example.springstarterdemo.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
