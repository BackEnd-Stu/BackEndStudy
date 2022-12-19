package com.servlet.web.frontcontroller.v3.controller;

import com.servlet.domain.MemberRepository;
import com.servlet.web.frontcontroller.Modelview;
import com.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public Modelview process(Map<String, String> paramMap) {
        return new Modelview("new-form");
    }
}
