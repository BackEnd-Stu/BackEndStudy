package com.servlet.domain.member;

import com.servlet.domain.Member;
import com.servlet.domain.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member1 = new Member ("hello", 20);
        Member member2 = new Member ("hello2", 25);

        Member savedMember = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
