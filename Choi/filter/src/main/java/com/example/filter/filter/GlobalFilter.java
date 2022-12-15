package com.example.filter.filter;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;



        // 전처리
        System.out.println("This is filter!!!!!!!!!!!!!" );
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/html");

        filterChain.doFilter(httpServletRequest, httpServletResponse);

        System.out.println("This is filter~~~~~~~~~~~~~~" );
        // 후처리

    }

    @Override
    public void destroy() {

    }
}
