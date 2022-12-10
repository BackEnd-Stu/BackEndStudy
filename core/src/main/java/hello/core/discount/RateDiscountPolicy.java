package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

// 4. spring, 컴포넌트 스캔
@Component
// 5. Bean에 Qualifier로 지정해서 사용
//@Qualifier("mainDisCountPolicy")
// 6. 무조건 해당 Bean이 먼저 사용되도록 설정
//@Primary
// 7. annotation을 직접 만들어서 사용
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPrecent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPrecent / 100;
        } else {
            return 0;
        }
    }
}
