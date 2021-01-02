package com.leenayoung.controller;

import com.leenayoung.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public void login() {
        System.out.println("로그인 요청");
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal(expression = "user") User user, HttpSession session) {
        System.out.println("---> 로그인 성공");
        session.setAttribute("user", user);

        return "redirect:home";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        System.out.println("---> 접근불가");
        return "redirect:home";
    }
}
