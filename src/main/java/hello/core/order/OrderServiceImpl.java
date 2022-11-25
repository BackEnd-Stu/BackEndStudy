package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 4. spring, 컴포넌트 스캔
// 5. 롬복 사용
//@RequiredArgsConstructor
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

    // 5. Qualifier로 지정해 놓은 빈을 가져오기
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDisCountPolicy") DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    // 6. Primary : Database커넥션과 관련된 경우, 메인 DB가 있고 보조DB가 있는 상황이라 가정
    // main을 가져올때도 Quailifier, 보조를 가져올 때도 Qualifier를 사용하는 것은 매우귀찮
    // -> main을 가져오는 경우에는 Primary를 걸어주기 : 의존관계 주입을 해도 심플하게 되, 룰을 팀에서 정하기만 하면 된다.
    // ex) main은 Primary로 사용하고 보조는 Qualifier나 직접 이름을 지정해서 사용하는 방식
        @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 2. 관심사의 분리
    // 대본보고 공연하듯이 정해진 로직만 수행하면 된다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
