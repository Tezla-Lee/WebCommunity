package com.leenayoung.controller;

import com.leenayoung.model.Board;
import com.leenayoung.service.BoardService;
import com.leenayoung.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommunityService communityService;

    @GetMapping("/insertBoard")
    public String viewInsertBoard() {
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board) {
        boardService.insertBoard(board);
        return "getBoard";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        Board getBoard = boardService.getBoard(board);
        getBoard.setCnt(board.getCnt() + 1);
        boardService.updateBoard(getBoard);
        model.addAttribute("board", getBoard);
        return "getBoard";
    }

    @GetMapping("/updateBoard")
    public String updateBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "updateBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "/getCommunity";
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
