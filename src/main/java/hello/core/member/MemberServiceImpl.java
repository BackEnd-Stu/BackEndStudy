package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 4. spring, 컴포넌트 스캔 : 컴포넌트 스캔을 쓰게 되면 Autowired를 사용하게 된다.
// 컴포넌트 스캔은 매핑은 자동으로 되는데 의존관계를 설정할 수 있는 방법이 없다. 수동으로 등록할 수 있는 장소가 없다.
@Component
public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 관심사의 분리, 배우가 배우를 섭외하는 의존관계 해제
    private final MemberRepository memberRepository;

    // 4. 컴포넌트 스캔을 하면 configuration-bean 방식과는 달리 의존관계 주입이 안되고 해당 클래스가 스캔되어 등록되는 것이기 때문에
    // 의존관계의 클래스를 등록하기 위해서는 자동 의존관계 주입이 필요하다.
    // Autowired라는 어노테이션을 생성자에 등록하면 여기에 MemberRepository 타입에 맞는 녀석을 찾아 와서 의존관계 클래스를 자동으로 연결해서 주입 해준다.
    @Autowired // ac.getBean(MemberRepository.class); 이런 식으로 동작
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
