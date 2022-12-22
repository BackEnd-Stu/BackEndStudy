package com.springmvc.controller;

import com.springmvc.dto.Dto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping ("/choi/anything")
    @ResponseBody
    public String test0 (Dto dto, Model model) {
        System.out.println("This is TestController");
        return "OK";
    }
}
