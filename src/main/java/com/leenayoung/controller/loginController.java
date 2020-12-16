package com.leenayoung.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class loginController {

    @GetMapping("/login")
    public void login() {
        System.out.println("로그인 요청");
    }
    @GetMapping("/loginSuccess")
    public void loginSuccess() {
        System.out.println("---> 로그인 성공");
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        System.out.println("---> 접근불가");
        return "/main";
    }
}
