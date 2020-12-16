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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommunityService communityService;

    @GetMapping("/insertBoard")
    public String viewInsertBoard(Community community, Model model) {
        model.addAttribute("community", communityService.getCommunity(community));
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board, HttpSession session) {
        board.setUser((User) session.getAttribute("user"));
        board.setCommunity((Community) session.getAttribute("community"));
        boardService.insertBoard(board);
        return "getBoard";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        Board getBoard = boardService.getBoard(board);
        getBoard.setCnt(board.getCnt() + 1);
        model.addAttribute("board", boardService.updateBoard(getBoard));
        return "getBoard";
    }

    @GetMapping("/updateBoard")
    public String viewUpdateBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "updateBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board, HttpSession session) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
        System.out.println(board.toString());
        board.setUser((User) session.getAttribute("user"));
        board.setCommunity((Community) session.getAttribute("community"));
        System.out.println(board.toString());
        boardService.updateBoard(board);
        return "getBoard";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoardList")
    public String getBoardList(Board board, Model model) {
        model.addAttribute("boardList", boardService.getBoardList(board));
        return "getBoardList";
    }

    @RequestMapping("/main")
    public String test() {
        return "getCommunity";
    }
}
