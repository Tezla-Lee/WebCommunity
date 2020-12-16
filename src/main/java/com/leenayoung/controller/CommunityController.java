package com.leenayoung.controller;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import com.leenayoung.service.BoardService;
import com.leenayoung.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Autowired
    BoardService boardService;

    @GetMapping("/getCommunity")
    public String getCommunity(Community community, Model model) {
        Community getCom = communityService.getCommunity(community);
        model.addAttribute("community", getCom);

        List<Board> boardList = boardService.getBoardListByCommunity_Seq(getCom);
        model.addAttribute("boardList", boardList);

        System.out.println(getCom.toString());
        System.out.println(boardList);
        return "getCommunity";
    }

    @PostMapping("/deleteCommunity")
    public String deleteCommunity(Community community) {
        communityService.deleteCommunity(community);
        return "adminPage.............."; // 나중에 추가
    }

    @PostMapping("/insertCommunity")
    public String insertCommunity(Community community) {
        communityService.insertCommunity(community);
        return "adminPage..........";
    }

    @PostMapping("/updateCommunity")
    public String updateCommunity(Community community) {
        communityService.updateCommunity(community);
        return "adminPage........";
    }
}
