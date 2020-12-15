package com.leenayoung.controller;

import com.leenayoung.model.User;
import com.leenayoung.repository.BoardRepository;
import com.leenayoung.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/main")
    public String main(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("communityList", communityRepository.findAll());
        return "main";
    }
}
