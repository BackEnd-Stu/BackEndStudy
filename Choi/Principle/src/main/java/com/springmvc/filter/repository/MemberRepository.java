package com.springmvc.filter.repository;

import com.springmvc.filter.member.MemberDto;

public interface MemberRepository {
	void save (MemberDto member);
	MemberDto findById(Long memberId);
}
