package com.springmvc.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class ShopLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("ShopId", request.getParameter("ShopId"));
        if (httpSession.getAttribute("ShopId").equals("shop")) {
            System.out.println("쇼핑 아이디가 맞습니다.");
            return true;
        } else {
            System.out.println("쇼핑 아이디가 아닙니다.");
            response.sendRedirect("/login/shop");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
