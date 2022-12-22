package com.springmvc.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class FilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterApplication.class, args);
    }

}