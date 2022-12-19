package com.servlet.web.frontcontroller.v2.controller;

import com.servlet.domain.Member;
import com.servlet.domain.MemberRepository;
import com.servlet.web.frontcontroller.MyView;
import com.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws SerialException, IOException, ServletException {

            String username = request.getParameter("username");
            int age = Integer.parseInt(request.getParameter("age"));

            Member member = new Member(username, age);
            System.out.println("member = " + member);
            memberRepository.save(member);

            // Model에 데이터를 보관한다.
            request.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
