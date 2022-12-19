package com.servlet.web.frontcontroller.v5;

import com.servlet.web.frontcontroller.Modelview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    boolean supports(Object handler);
    Modelview handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws SecurityException, IOException;
}
