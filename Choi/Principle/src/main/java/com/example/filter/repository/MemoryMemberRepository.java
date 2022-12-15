package com.example.filter.repository;

import com.example.filter.member.MemberDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
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
