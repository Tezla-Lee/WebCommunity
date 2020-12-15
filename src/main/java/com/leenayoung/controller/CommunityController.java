package com.leenayoung.controller;

import com.leenayoung.model.Community;
import com.leenayoung.repository.BoardRepository;
import com.leenayoung.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommunityController {

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/getCommunity")
    public String getCommunity(Community community, Model model) {
        model.addAttribute("community", community);
        model.addAttribute("boardList", boardRepository.findBoardByCommunity(community.getName()));
        return "getCommunity";
    }

    @PostMapping("/deleteCommunity")
    public String deleteCommunity(Community community) {
        communityRepository.deleteById(community.getSeq());
        return "adminPage.............."; // 나중에 추가
    }

    @PostMapping("/insertCommunity")
    public String insertCommunity(Community community) {
        communityRepository.save(community);
        return "adminPage..........";
    }

    @PostMapping("/updateCommunity")
    public String updateCommunity(Community community) {
        Community originComm = communityRepository.findById(community.getSeq()).get();
        originComm.setName(community.getName());
        return "adminPage........";
    }


}
