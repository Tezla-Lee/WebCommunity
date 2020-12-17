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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Autowired
    BoardService boardService;

    @GetMapping("/getCommunity")
    public String getCommunity(Community community, Model model, HttpSession session) {
        Community getCom = communityService.getCommunity(community);
        model.addAttribute("community", getCom);

        List<Board> boardList = boardService.getBoardListByCommunity_Seq(getCom);
        model.addAttribute("boardList", boardList);
//        session.setAttribute("community", getCom);

        model.addAttribute("communityList", communityService.getCommunityList());

        System.out.println(getCom.toString());
        System.out.println(boardList);
        return "getCommunity";
    }

    @GetMapping("/communitySearch")
    public String searchCommunity(Model model, @RequestParam("searchCondition") String searchCondition, @RequestParam("searchKeyword") String searchKeyword,
                                  @RequestParam("communitySeq") long communitySeq) {
        List<Board> boardList;
        switch (searchCondition) {
            case "title":
                System.out.println("---> getBoardListByTitleAndCommunitySeq");
                boardList = boardService.getBoardListByTitleAndCommunitySeq(searchKeyword, communitySeq);
                break;
            case "content":
                boardList = boardService.getBoardListByContentAndCommunitySeq(searchKeyword, communitySeq);
                break;
            case "writer":
                boardList = boardService.getBoardListByUserIDAndCommunitySeq(searchKeyword, communitySeq);
                break;
            default:
                boardList = null;
        }
        for (Board board : boardList) {
            System.out.println(board.toString());
        }
        Community tempComm = new Community();
        tempComm.setSeq(communitySeq);
        model.addAttribute("community", communityService.getCommunity(tempComm));
        model.addAttribute("boardList", boardList);
        model.addAttribute("communityList", communityService.getCommunityList());
        model.addAttribute("searchCondition", searchCondition);
        model.addAttribute("searchKeyword", searchKeyword);
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
