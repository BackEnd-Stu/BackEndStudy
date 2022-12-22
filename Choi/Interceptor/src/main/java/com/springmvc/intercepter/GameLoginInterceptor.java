package com.springmvc.intercepter;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class GameLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception, ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("GameId", request.getParameter("GameId"));
        if (httpSession.getAttribute("GameId").equals("game")) {
            System.out.println("게임 아이디가 맞습니다.");
            return true;
        } else {
            System.out.println("게임 아이디가 아닙니다.");
            response.sendRedirect("/login/game");
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
