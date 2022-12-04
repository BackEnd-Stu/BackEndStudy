package com.example.member;

import com.example.AppConfig;
import com.example.member.Grade;
import com.example.member.MemberDto;
import com.example.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberAnnotationConfigTest {
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	
	MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

			@Test
			void TestConfig() {
				MemberDto member = new MemberDto(1L, "memberA", Grade.VIP);
				memberService.join(member);

				MemberDto findMember = memberService.findMember(1L);
				
				Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
				
				System.out.println("new member = " + member.getName());
				System.out.println("find Member = " + findMember.getName());
			}	
}
