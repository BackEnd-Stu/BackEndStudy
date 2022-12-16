package com.example.controller;

import com.example.dto.Dto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping ("/choi/ic")
    public String test0 (Dto dto, Model model) {
        System.out.println("This is TestController");
        model.addAttribute("dto", dto);
        return "testView";
    }

    @RequestMapping ("/ic")
    public String test1 (Dto dto, Model model) {
        System.out.println("This is TestController");
        model.addAttribute("dto", dto);
        return "testView";
    }
}
