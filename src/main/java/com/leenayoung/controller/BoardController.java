package com.leenayoung.controller;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import com.leenayoung.model.User;
import com.leenayoung.service.BoardService;
import com.leenayoung.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommunityService communityService;

    @GetMapping("/insertBoard")
    public String viewInsertBoard(Community community, Model model, @RequestParam int page) {
        model.addAttribute("community", communityService.getCommunity(community));
        model.addAttribute("page", page);
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board, HttpSession session, @RequestParam long communitySeq, @RequestParam int page) {
<<<<<<< HEAD
        System.out.println("===> insertBoard...");
=======
        System.out.println("===> insertBoard.................................................");
>>>>>>> 0984681... fix: getBoard, insertBoard, updateBoard error after paging
        board.setUser((User) session.getAttribute("user"));
        Community community = new Community();
        community.setSeq(communitySeq);
        board.setCommunity(communityService.getCommunity(community));
        System.out.println(board.toString());
        boardService.insertBoard(board);
        return "redirect:getBoard?communitySeq=" + communitySeq + "&seq=" + board.getSeq() + "&page=" + page;
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model, @RequestParam long communitySeq, @RequestParam int page) {
        model.addAttribute("board", boardService.updateBoardCount(boardService.getBoard(board)));
        Community community = new Community();
        community.setSeq(communitySeq);
        model.addAttribute("community", communityService.getCommunity(community));
        model.addAttribute("communityList", communityService.getCommunityList());
        model.addAttribute("page", page);

        return "getBoard";
    }

    @GetMapping("/updateBoard")
    public String viewUpdateBoard(Board board, Model model, @RequestParam long communitySeq, @RequestParam int page) {
        model.addAttribute("board", boardService.getBoard(board));
        model.addAttribute("page", page);
        model.addAttribute("communitySeq", communitySeq);
        return "updateBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board, HttpSession session, @RequestParam long communitySeq, @RequestParam int page, Model model) {
<<<<<<< HEAD
        System.out.println("===> update Board...");
=======
        System.out.println("===> update Board...............");
>>>>>>> 0984681... fix: getBoard, insertBoard, updateBoard error after paging
        System.out.println(board.toString());
        board.setUser((User) session.getAttribute("user"));
        board.setCommunity((Community) session.getAttribute("community"));
        Community community = new Community();
        community.setSeq(communitySeq);
        model.addAttribute("community", communityService.getCommunity(community));
        model.addAttribute("communityList", communityService.getCommunityList());
        model.addAttribute("page", page);
        model.addAttribute("communitySeq", communitySeq);
<<<<<<< HEAD
        model.addAttribute("board", boardService.updateBoard(board));
=======
        System.out.println(board.toString());
        model.addAttribute("board", boardService.updateBoard(board));
        System.out.println("통과!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
>>>>>>> 0984681... fix: getBoard, insertBoard, updateBoard error after paging
        return "getBoard";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board, @RequestParam long communitySeq, Model model) {
        boardService.deleteBoard(board);
        return "redirect:getCommunity?seq=" + communitySeq;
    }

    @GetMapping("/getBoardList")
    public String getBoardList(Board board, Model model) {
        model.addAttribute("boardList", boardService.getBoardList());
        return "getBoardList";
    }


}
