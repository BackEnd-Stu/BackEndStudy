package com.example.repository;

import com.example.member.MemberDto;

public interface MemberRepository {
	void save (MemberDto member);
	MemberDto findById(Long memberId);
}
