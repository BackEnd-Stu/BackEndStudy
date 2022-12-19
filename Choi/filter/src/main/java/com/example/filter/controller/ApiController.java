package com.example.filter.controller;

import com.example.filter.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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