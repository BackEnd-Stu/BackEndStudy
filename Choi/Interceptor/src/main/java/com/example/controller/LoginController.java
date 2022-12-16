package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping ("/shop")
    public String shopping () {
        return "shopForm";
    }

    @RequestMapping ("/game")
    public String gaming () {
        return "gameForm";
    }

    @RequestMapping ("/ShopLoginCheck")
    @ResponseBody
    public String ShopLoginCheck () {
        return "로그인 성공했습니다.";
    }

    @RequestMapping ("/GameLoginCheck")
    @ResponseBody
    public String GameLoginCheck () {
        return "로그인 성공했습니다.";
    }
}
