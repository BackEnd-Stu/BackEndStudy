package com.example.filter.singleton;

import com.example.filter.AppConfig;
import com.example.filter.member.MemberServiceImpl;
import com.example.filter.repository.MemberRepository;
import com.example.filter.order.OrderServiceImpl;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

//모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

//모두 같은 인스턴스를 참고하고 있다.

        AssertionsForClassTypes.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);

        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
