package hello.core;

// 1. 쌩 java 버전
//public class AppConfig {
//    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    public MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//
//    public OrderServiceImpl orderService() {
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    public DiscountPolicy discountPolicy() {
//        return new RateDiscountPolicy();
//    }
//}

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 3. DI를 적용한, spring framework 사용 버전
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderServiceImpl orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
