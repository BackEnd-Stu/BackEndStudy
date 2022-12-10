package hello.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    // 순수한 자바 코드로 테스트? 생성자 주입 방식을 선택하는 이유에는 여러 가지가 있지만
    // 생성자 주입 방식이 프레임워크에 의존하지 않고 순수한 자바 언어의 특징을 잘 살려주기 때문인 것도 있다.
    // 기본으로 생성자 주입을 사용하고, 필수 값이 아닌 경우에는 수정자 주입 방식을 옵션으로 부여하면
    // 편리하게 생성자 주입과 수정자 주입 방식을 동시에 사용할 수 있다.
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        // 생성자 주입 방식을 사용해야 문제를 바로 추적할 수 있다(컴파일 오류 발생 - 좋은 오류)
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
