package com.leenayoung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;

@Controller
public class loginController {

    @GetMapping("/login")
    public void login() {
        System.out.println("로그인 요청");
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        System.out.println("---> 로그인 성공");
        return "redirect:home";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        System.out.println("---> 접근불가");
        return "redirect:home";
    }
}
