package com.example.filter.repository;

import com.example.filter.member.MemberDto;

public interface MemberRepository {
	void save (MemberDto member);
	MemberDto findById(Long memberId);
}
