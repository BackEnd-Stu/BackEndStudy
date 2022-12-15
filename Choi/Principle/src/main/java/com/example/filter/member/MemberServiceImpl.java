package com.example.filter.member;

import com.example.filter.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

//	private final MemberRepository memberRepository = new MemoryMemberRepository();

	 private final MemberRepository memberRepository;

//	 lombok @RequiredArgsConstructor를 쓰면 생략가능
//	 @Autowired
//	 public MemberServiceImpl(MemberRepository memberRepository) {
//		 this.memberRepository = memberRepository;
//	 }
	 public void join(MemberDto member) {
		 memberRepository.save(member);
	 }
	 public MemberDto findMember(Long memberId) {
		 return memberRepository.findById(memberId);
	 }


	//테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
