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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    CommunityService communityService;

    @Autowired
    BoardService boardService;

    @GetMapping({"/", "/home"})
    public String main(User user, Model model) {
        System.out.println("===> main Get.............");
        model.addAttribute("user", user);
        model.addAttribute("communityList", communityService.getCommunityList());
        model.addAttribute("boardList", boardService.getBoardList());
        return "main";
    }

    @PostMapping({"/", "/home"})
    public String main(User user, Model model, @RequestParam("searchCondition") String searchCondition, @RequestParam("searchKeyword") String searchKeyword) {
        System.out.println("===> main Post.............");
        System.out.println(searchCondition);
        model.addAttribute("user", user);
        model.addAttribute("communityList", communityService.getCommunityList());
        List<Board> boardList;
        if (searchCondition == null) {
            boardList = null;
        } else {
            switch (searchCondition) {
                case "title":
                    boardList = boardService.getBoardListByTitle(searchKeyword);
                    break;
                case "content":
                    boardList = boardService.getBoardListByContent(searchKeyword);
                    break;
                case "writer":
                    boardList = boardService.getBoardListByUser_ID(searchKeyword);
                    break;
                case "community":
                    boardList = boardService.getBoardListByCommunity_Name(searchKeyword);
                    break;
                default:
                    boardList = null;
            }
        }
        model.addAttribute("boardList", boardList);
        return "main";
    }

}