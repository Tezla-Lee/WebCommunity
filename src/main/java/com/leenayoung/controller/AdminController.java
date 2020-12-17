package com.leenayoung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public void viewAdmin() {
        System.out.println("어드민페이지요청");
    }

}
