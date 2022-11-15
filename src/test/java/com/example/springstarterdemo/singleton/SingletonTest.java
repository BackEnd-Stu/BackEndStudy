package com.example.springstarterdemo.singleton;

import com.example.springstarterdemo.AppConfig;
import com.example.springstarterdemo.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        MemberService memberService1 = appConfig.memberService();

        //이런식으로 요청시마다 새로 객체가 생성

        assertThat(memberService).isNotSameAs(memberService1);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance1 = SingletonService.getInstance();

        assertThat(instance).isSameAs(instance1);


    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


        //이런식으로 요청시마다 새로 객체가 생성

        assertThat(memberService).isSameAs(memberService2);

    }
}
