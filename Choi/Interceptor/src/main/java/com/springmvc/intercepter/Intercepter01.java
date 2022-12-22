package com.springmvc.intercepter;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Intercepter01 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        System.out.println("request = " + request + ", request.getMethod() = " + request.getMethod() + ", request.getRequestURI() = " + request.getRequestURI());
        System.out.println("handler = " + handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        System.out.println("modelAndView = " + modelAndView);
        System.out.println("request = " + request + ", request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("handler = " + handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion: 뷰 랜더링이 마친 후 나오는 과정.");
    }
}
