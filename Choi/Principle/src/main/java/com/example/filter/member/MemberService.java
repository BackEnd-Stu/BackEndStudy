package com.example.filter.member;

public interface MemberService {
	void join(MemberDto memberDto);
	MemberDto findMember(Long memberId);
}
