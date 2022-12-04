package com.example.order;

import com.example.AppConfig;
import com.example.member.Grade;
import com.example.member.MemberDto;
import com.example.member.MemberService;
import com.example.order.OrderDto;
import com.example.order.OrderService;
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


