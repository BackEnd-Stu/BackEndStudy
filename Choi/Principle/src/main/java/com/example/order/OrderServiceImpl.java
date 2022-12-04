package com.example.order;

import com.example.discount.DiscountPolicy;
import com.example.member.MemberDto;
import com.example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	// lombok @RequiredArgsConstructor을 쓰면 생략 가능.
//	@Autowired
//	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//		this.memberRepository = memberRepository;
//		this.discountPolicy = discountPolicy;
//	}

	@Override
	public OrderDto createOrder(Long memberId, String itemName, int itemPrice) {
		MemberDto memberDto = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(memberDto, itemPrice);
		return new OrderDto(memberId, itemName, itemPrice, discountPrice);
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
