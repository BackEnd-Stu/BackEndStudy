package com.example.filter.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GlobalFilter3 implements javax.servlet.Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;

            // 전처리
            System.out.println("Before - This is filter3" );




            filterChain.doFilter(httpServletRequest, httpServletResponse);

            // 후처리
            System.out.println("After - This is filter3" );


        }
}
