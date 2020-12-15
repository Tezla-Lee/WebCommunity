package com.leenayoung.service;

import com.leenayoung.model.Comment;
import com.leenayoung.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void insertComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        Comment newComment = commentRepository.findById(comment.getSeq()).get();

        newComment.setContent(comment.getContent());
    }

    @Override
    public List<Comment> getCommentList(Comment comment) {
        return (List<Comment>) commentRepository.findAll();
    }
}
