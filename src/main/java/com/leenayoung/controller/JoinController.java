package com.leenayoung.controller;

import com.leenayoung.model.User;
import com.leenayoung.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class JoinController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/join")
    public String joinView() {
        return "join";
    }

    @PostMapping("/join")
    public String join(User user, Model model,@RequestParam("passwordConfirm") String pwConfirm) {

        int result = userService.insertUser(user, pwConfirm);

        if(result > 0 )  {
            model.addAttribute("user", user);
            return "joinSuccess";
        } else {
            System.out.println("회원가입실패");
            return "join";
        }

    }

}
