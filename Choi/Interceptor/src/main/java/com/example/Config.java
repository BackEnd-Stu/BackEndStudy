package com.example;

import com.example.intercepter.GameLoginInterceptor;
import com.example.intercepter.Intercepter01;
import com.example.intercepter.ShopLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Intercepter01()).addPathPatterns("/choi/**");
        registry.addInterceptor(new GameLoginInterceptor()).addPathPatterns("/login/GameLoginCheck");
        registry.addInterceptor(new ShopLoginInterceptor()).addPathPatterns("/login/ShopLoginCheck");
    }
}
