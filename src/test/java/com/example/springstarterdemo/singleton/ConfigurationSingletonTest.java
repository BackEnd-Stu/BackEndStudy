package com.example.springstarterdemo.singleton;

import com.example.springstarterdemo.AppConfig;
import com.example.springstarterdemo.member.MemberRepository;
import com.example.springstarterdemo.member.MemberServiceImpl;
import com.example.springstarterdemo.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class); // 원래는 구체 타입으로 이렇게 꺼내면 안좋음
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository bean = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository = memberService.getMemberRepository();
        MemberRepository memberRepository1 = orderService.getMemberRepository();


        System.out.println(memberRepository + " = " + memberRepository1 + " = " + bean);
        //읭?? 똑같네??

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(bean).isSameAs(memberRepository);
    }

    @Test
    void configuration(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
