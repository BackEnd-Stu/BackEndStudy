package com.example.springstarterdemo.order;

import com.example.springstarterdemo.discount.DiscountPolicy;
import com.example.springstarterdemo.discount.FixDiscountPolicy;
import com.example.springstarterdemo.discount.RateDiscountPolicy;
import com.example.springstarterdemo.member.Member;
import com.example.springstarterdemo.member.MemberRepository;
import com.example.springstarterdemo.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Component("service")
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
