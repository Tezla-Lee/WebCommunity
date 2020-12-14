package com.leenayoung.service;

import com.leenayoung.model.Comment;

import java.util.List;

public interface CommentService {
    void insertComment(Comment comment);

    void deleteComment(Comment comment);

    void updateComment(Comment comment);

    List<Comment> getCommentList(Comment comment);
}
