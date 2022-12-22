package com.springmvc.filter.controller;

import com.springmvc.filter.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController

public class ApiController {

    @RequestMapping("/user")
    public String user(User user) {
        user.setAge(28);
        user.setName("yoon");
        System.out.println("user = " + user);
        return "user";
    }
}