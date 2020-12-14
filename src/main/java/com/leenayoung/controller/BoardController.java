package com.leenayoung.controller;

import com.leenayoung.model.Board;
import com.leenayoung.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/insertBoard")
    public String insertBoard(Board board) {
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "getCommentList";
    }

    @GetMapping("/reviseBoard")
    public String reviseBoard(Board board, Model model) {
        model.addAttribute("board", board);
        return "reviseBoard";
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

    @PostMapping("/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "redirect:getBoardList";
    }
}
