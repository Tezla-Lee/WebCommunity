package com.leenayoung.controller;

import com.leenayoung.model.Board;
import com.leenayoung.model.User;
import com.leenayoung.service.BoardService;
import com.leenayoung.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    CommunityService communityService;

    @Autowired
    BoardService boardService;

    @GetMapping({"/", "/home"})
    public String main(Model model, HttpSession session) {
        System.out.println("===> main Get.............");
//        model.addAttribute("communityList", communityService.getCommunityList());
//        model.addAttribute("boardList", boardService.getBoardList());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        session.setAttribute("time", simpleDateFormat.format(new Date()));
        return "redirect:mainpage?page=0";
    }

    @GetMapping("/mainpage")
    public String mainPage(Model model, @RequestParam int page) {
        System.out.println("===> getMainpage...................................................");
        System.out.println(page);
        model.addAttribute("communityList", communityService.getCommunityList());
        model.addAttribute("communityList", communityService.getCommunityList());

        // paging
        Pageable pageable = PageRequest.of(page, 15);
        Page<Board> pageInfo = boardService.getBoardListByTitle("", pageable);
        List<Board> boardList = pageInfo.getContent();
        model.addAttribute("boardList", boardList);
        int totalPage = pageInfo.getTotalPages();
        model.addAttribute("totalPage", pageInfo.getTotalPages() - 1);
        model.addAttribute("searchCondition", "title");
        model.addAttribute("searchKeyword", "");
        model.addAttribute("page", page);
        System.out.println(totalPage);

        return "main";
    }

    @GetMapping("/mainSearch")
    public String main(User user, Model model, @RequestParam("searchCondition") String searchCondition, @RequestParam("searchKeyword") String searchKeyword, @RequestParam int page) {
        System.out.println("===> main Post.............");
        System.out.println("searchCondition : " + searchCondition);
        System.out.println("searchKeyword : " + searchKeyword);
        System.out.println(page);
        model.addAttribute("user", user);
        model.addAttribute("communityList", communityService.getCommunityList());
        model.addAttribute("searchCondition", searchCondition);
        model.addAttribute("searchKeyword", searchKeyword);
        Page<Board> pageInfo;
        Pageable pageable = PageRequest.of(page, 15);
        switch (searchCondition) {
            case "title":
                pageInfo = boardService.getBoardListByTitle(searchKeyword, pageable);
                model.addAttribute("titleCheck", true);
                break;
            case "content":
                pageInfo = boardService.getBoardListByContent(searchKeyword, pageable);
                model.addAttribute("contentCheck", true);
                break;
            case "writer":
                pageInfo = boardService.getBoardListByUser_ID(searchKeyword, pageable);
                model.addAttribute("writerCheck", true);
                break;
            case "community":
                pageInfo = boardService.getBoardListByCommunity_Name(searchKeyword, pageable);
                model.addAttribute("communityCheck", true);
                break;
            default:
                pageInfo = null;
        }
        List<Board> boardList = pageInfo.getContent();

        model.addAttribute("boardList", boardList);
        model.addAttribute("boardListSize", boardList.size());

        int totalPage = pageInfo.getTotalPages();
        if (totalPage == 0) {
            model.addAttribute("totalPage", 0);
        } else {
            model.addAttribute("totalPage", pageInfo.getTotalPages() - 1);
        }

        return "main";
    }

}