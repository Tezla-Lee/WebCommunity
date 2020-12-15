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

//    @Autowired
//    UserServiceImpl userService;
//
//
//    @GetMapping("login")
//    public String loginView() {
//        System.out.println("로그인페이지로 이동");
//        return "login";
//    }
//    @PostMapping("login")
//    public String login(User user, HttpSession session) {
//        int result = userService.login(user, session);
//
//        if(result ==1 ) {
//            System.out.println("겟보드리스트로가세요");
//            return "getBoardList";
//        } else {
//            System.out.println("아이디비번이 틀렸스빈다");
//            return "login";
//        }
//
//    }

}
