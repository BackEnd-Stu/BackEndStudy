package com.example.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
//	MemberService memberService = new MemberServiceImpl();

	@Test
	void join() {
		MemberDto memberDto = new MemberDto (1L, "memberOne", Grade.VIP);

		memberService.join(memberDto);
		MemberDto findMember = memberService.findMember(1L);

		Assertions.assertThat(memberDto).isEqualTo(findMember);
	}
}
