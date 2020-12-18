package com.leenayoung.controller;

import com.leenayoung.model.Board;
import com.leenayoung.model.Comment;
import com.leenayoung.model.User;
import com.leenayoung.service.BoardService;
import com.leenayoung.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    BoardService boardService;

    @PostMapping("/insertComment")
    public String insertComment(Board board, Comment comment, HttpSession session, Model model, @RequestParam("communitySeq") long communitySeq,
                                @RequestParam int page) {
        System.out.println("===> insertComment ..................");
//        System.out.println("communitySeq : " + communitySeq);
//        System.out.println("board : " + board.toString());
//        System.out.println("comment : " + comment.toString());
        comment.setUser((User) session.getAttribute("user"));
        comment.setBoard(boardService.getBoard(board));
        commentService.insertComment(comment);
        return "redirect:getBoard?communitySeq=" + communitySeq + "&seq=" + board.getSeq() + "&page=" + page;
    }

    @GetMapping("/deleteComment")
    public String deleteComment(Comment comment) {
        commentService.deleteComment(comment);
        return "redirect:GetBoard";
    }

    @PostMapping("/reviseComment")
    public String reviseComment(Comment comment, Model model) {
        model.addAttribute("comment", comment);
        return "reviseComment";
    }

    @PostMapping("/updateComment")
    public String updateComment(Comment comment) {
        commentService.updateComment(comment);
        return "getBoard";
    }

    @GetMapping("/getCommentList")
    public String getCommentList(Comment comment, Model model) {
        model.addAttribute("commentList", commentService.getCommentList(comment));
        return "getBoard";
    }
}
