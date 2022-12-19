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
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("GlobalFilter가 생성 됩니다.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 전처리
        System.out.println("Before This is filter1" );

        httpServletResponse.setHeader("my-header","hello");
        System.out.println("Setting custom info");

        filterChain.doFilter(httpServletRequest, httpServletResponse);

        // 후처리
        System.out.println("After This is filter1" );
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter가 삭제됩니다.");
    }
}
