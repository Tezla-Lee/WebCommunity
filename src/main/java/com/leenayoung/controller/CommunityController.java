package com.leenayoung.controller;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import com.leenayoung.service.BoardService;
import com.leenayoung.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Autowired
    BoardService boardService;

    @GetMapping("/getCommunity")
    public String getCommunity(Community community, Model model, @RequestParam int page) {
        System.out.println("===> getCommunity...................................................");
        Community getCom = communityService.getCommunity(community);
        model.addAttribute("community", getCom);

        model.addAttribute("communityList", communityService.getCommunityList());

        model.addAttribute("page", page);

        // paging
        Pageable pageable = PageRequest.of(page, 10);
        Page<Board> pageInfo = boardService.getBoardByCommunity_Seq(getCom.getSeq(), pageable);
        List<Board> boardList = pageInfo.getContent();
        model.addAttribute("boardList", boardList);
        int totalPage = pageInfo.getTotalPages();
        if (totalPage == 0) {
            model.addAttribute("totalPage", 0);
        } else {
            model.addAttribute("totalPage", pageInfo.getTotalPages() - 1);
        }


        System.out.println(totalPage);
        return "getCommunity";
    }

    @GetMapping("/communitySearch")
    public String searchCommunity(Model model, @RequestParam("searchCondition") String searchCondition, @RequestParam("searchKeyword") String searchKeyword,
                                  @RequestParam("communitySeq") long communitySeq, @RequestParam int page) {

        System.out.println("===> communitySearch..................");
        System.out.println(page);
        Page<Board> pageInfo;
        Pageable pageable = PageRequest.of(page, 10);
        switch (searchCondition) {
            case "title":
                pageInfo = boardService.getBoardListByTitleAndCommunitySeq(searchKeyword, communitySeq, pageable);
                break;
            case "content":
                pageInfo = boardService.getBoardListByContentAndCommunitySeq(searchKeyword, communitySeq, pageable);
                break;
            case "writer":
                pageInfo = boardService.getBoardListByUserIDAndCommunitySeq(searchKeyword, communitySeq, pageable);
                break;
            default:
                pageInfo = null;
        }
        List<Board> boardList = pageInfo.getContent();
        System.out.println(boardList);
        Community tempComm = new Community();
        tempComm.setSeq(communitySeq);
        model.addAttribute("community", communityService.getCommunity(tempComm));
        model.addAttribute("boardList", boardList);
        model.addAttribute("communityList", communityService.getCommunityList());
        model.addAttribute("searchCondition", searchCondition);
        model.addAttribute("searchKeyword", searchKeyword);
        int totalPage = pageInfo.getTotalPages();
        if (totalPage == 0) {
            model.addAttribute("totalPage", 0);
        } else {
            model.addAttribute("totalPage", pageInfo.getTotalPages() - 1);
        }
        model.addAttribute("boardListSize", boardList.size());
        return "getCommunity";
    }


    @PostMapping("/deleteCommunity")
    public String deleteCommunity(Community community) {
        communityService.deleteCommunity(community);
        return "adminPage"; // 나중에 추가
    }

    @PostMapping("/insertCommunity")
    public String insertCommunity(Community community) {
        communityService.insertCommunity(community);
        return "adminPage";
    }

    @PostMapping("/updateCommunity")
    public String updateCommunity(Community community) {
        communityService.updateCommunity(community);
        return "adminPage";
    }
}
