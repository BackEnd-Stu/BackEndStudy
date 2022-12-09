package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    // @AfterEach : test가 끝나면 무조건 실행됨 -> 전체 테스트 수행할 경우 각 테스트의 순서 보장이 되지 않기 때문에
    // clear하지 않을 경우 저장 테스트의 결과가 전체 데이터 조회 테스트에 나타나서 의도대로 테스트를 할 수 없게 된다.
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    // 저장 테스트
    @Test
    void save() {
        // given
        Member member = new Member("hello", 20);

        // when
        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedMember.getId());

        // then
        assertThat(findMember).isEqualTo(savedMember);
    }

    // 모든 데이터를 조회하는 테스트
    @Test
    void findAll() {
        // given
        Member member1 = new Member("hello1", 21);
        Member member2 = new Member("hello2", 22);

        // when
        List<Member> savedMembers = new ArrayList<>();
        savedMembers.add(memberRepository.save(member1));
        savedMembers.add(memberRepository.save(member2));
        List<Member> findAllMembers = memberRepository.findAll();

        // then
        assertThat(findAllMembers.size()).isEqualTo(2);
        assertThat(findAllMembers).isEqualTo(savedMembers);
        // ==
        assertThat(findAllMembers).contains(member1, member1);
    }
}