package com.leenayoung.controller;

import com.leenayoung.model.Comment;
import com.leenayoung.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/insertComment")
    public String insertComment(Comment comment) {
        commentService.insertComment(comment);
        return "redirect:GetBoard";
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
