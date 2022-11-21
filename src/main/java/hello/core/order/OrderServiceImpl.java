package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 4. spring, 컴포넌트 스캔
// 5. 롬복 사용
@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService{

    // 2. 관심사의 분리
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 1. 할인 정책 : 정액 -> 정률
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 2. 관심사의 분리
    // 생성자 주입 방식을 사용해야 final키워드(한번 생성되면 바뀔수 없도록)를 사용할 수 있다.
    // * 오직 생성자 주입 방식만 final을 사용할 수 있다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 4. component scan을 위해 의존성 주입
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    // 2. 관심사의 분리
    // 대본보고 공연하듯이 정해진 로직만 수행하면 된다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
