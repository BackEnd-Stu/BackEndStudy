package com.servlet.web.frontcontroller.v3.controller;

import com.servlet.domain.Member;
import com.servlet.domain.MemberRepository;
import com.servlet.web.frontcontroller.Modelview;
import com.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public Modelview process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        Modelview mv = new Modelview("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
