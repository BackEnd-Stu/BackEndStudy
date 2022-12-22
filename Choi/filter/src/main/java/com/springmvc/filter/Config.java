package com.springmvc.filter;

import com.springmvc.filter.filter.GlobalFilter;
import com.springmvc.filter.filter.GlobalFilter2;
import com.springmvc.filter.filter.GlobalFilter3;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

        @Bean
        public FilterRegistrationBean firstFilterRegister() {
            FilterRegistrationBean registrationBean = new FilterRegistrationBean(new GlobalFilter());
            registrationBean.setOrder(2);
            return registrationBean;
        }

        @Bean
        public FilterRegistrationBean secondFilterRegister() {
            FilterRegistrationBean registrationBean = new FilterRegistrationBean(new GlobalFilter2());
            registrationBean.setOrder(1);
            return registrationBean;
        }

    @Bean
    public FilterRegistrationBean ThirdFilterRegister() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new GlobalFilter3());
        registrationBean.setOrder(3);
        return registrationBean;
    }
    }

