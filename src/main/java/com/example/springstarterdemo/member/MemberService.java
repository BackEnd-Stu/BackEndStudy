package com.example.springstarterdemo.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
