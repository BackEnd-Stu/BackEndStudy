package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

// 4. spring, 컴포넌트 스캔
@Component
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
