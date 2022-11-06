package com.example.member;

import com.example.repository.MemberRepository;
import com.example.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

//	private final MemberRepository memberRepository = new MemoryMemberRepository();

	private final MemberRepository memberRepository;
	 public MemberServiceImpl(MemberRepository memberRepository) {
	 this.memberRepository = memberRepository;
	 }
	 public void join(MemberDto member) {
	 memberRepository.save(member);
	 }
	 public MemberDto findMember(Long memberId) {
	 return memberRepository.findById(memberId);
	 }

}
