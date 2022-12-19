package com.servlet.web.frontcontroller.v2.controller;

import com.servlet.web.frontcontroller.MyView;
import com.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws SerialException, IOException, ServletException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
