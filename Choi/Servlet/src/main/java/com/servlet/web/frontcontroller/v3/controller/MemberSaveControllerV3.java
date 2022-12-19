package com.servlet.web.frontcontroller.v3.controller;

import com.servlet.domain.Member;
import com.servlet.domain.MemberRepository;
import com.servlet.web.frontcontroller.Modelview;
import com.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public Modelview process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        Modelview mv = new Modelview("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
