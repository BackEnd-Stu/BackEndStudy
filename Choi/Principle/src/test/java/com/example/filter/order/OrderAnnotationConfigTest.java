package com.example.filter.order;

import com.example.filter.AppConfig;
import com.example.filter.member.Grade;
import com.example.filter.member.MemberDto;
import com.example.filter.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderAnnotationConfigTest {
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
			MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
			OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

			long memberId = 1L;
			MemberDto member = new MemberDto(memberId, "memberA", Grade.VIP);
			
			@Test
			void Test() {
				
			memberService.join(member);

			OrderDto order = orderService.createOrder(memberId, "itemA", 10000);

			System.out.println("order = " + order);

		}
}


