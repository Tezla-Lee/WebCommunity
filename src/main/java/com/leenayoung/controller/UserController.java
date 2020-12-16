package com.leenayoung.controller;

import com.leenayoung.model.User;
import com.leenayoung.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/join")
    public String joinView() {
        return "join";
    }

    @PostMapping("/join")
    public String join(User user) {
        int result = userService.insertUser(user);

        if(result > 0  ) {
            return "joinSueccess";
        } else {
            System.out.println("회원가입실패");
            return "join";
        }

    }

}
