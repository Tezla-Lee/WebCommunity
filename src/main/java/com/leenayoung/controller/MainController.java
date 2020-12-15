package com.leenayoung.controller;

import com.leenayoung.model.Board;
import com.leenayoung.model.User;
import com.leenayoung.service.BoardService;
import com.leenayoung.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    CommunityService communityService;

    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String main(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("communityList", communityService.getCommunityList());
        return "main";
    }

    @PostMapping("/")
    public String main(User user, Model model, Board board) {
        model.addAttribute("user", user);
        model.addAttribute("communityList", communityService.getCommunityList());
        model.addAttribute("board", board);
        return "main";
    }

}