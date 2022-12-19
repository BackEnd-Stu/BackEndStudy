package com.example.filter.member;

import com.example.filter.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

	
	MemberService memberService;

	@BeforeEach
	public void beforeEach() {
	AppConfig appConfig = new AppConfig();
	memberService = appConfig.memberService();
	}
	
	@Test
	void Test1() {
		MemberDto member = new MemberDto(1L, "memberA", Grade.VIP);
		memberService.join(member);
	
		MemberDto findMember = memberService.findMember(1L);
		
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
		
		System.out.println("new member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());	
	}
}