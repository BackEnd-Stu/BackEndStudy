package com.example.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.member.MemberDto;

public class MemoryMemberRepository implements MemberRepository{

	private static Map<Long, MemberDto> store = new HashMap<>();

	@Override
	public void save(MemberDto memberDto) {
		store.put(memberDto.getId(), memberDto);
	}

	@Override
	public MemberDto findById(Long memberId) {
		return store.get(memberId);
	}
}
