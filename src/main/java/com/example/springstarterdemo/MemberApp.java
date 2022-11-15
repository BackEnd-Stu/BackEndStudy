package com.example.springstarterdemo;

import com.example.springstarterdemo.member.Grade;
import com.example.springstarterdemo.member.Member;
import com.example.springstarterdemo.member.MemberService;
import com.example.springstarterdemo.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //getBean("메소드명", 메소드타입)

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member name == " + member.getName());
        System.out.println("find member == " + findMember.getName());
    }
}
