package com.leenayoung.repository;

import com.leenayoung.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void testGetCommentList() {
        List<Comment> commentList = (List<Comment>) commentRepository.findAll();
        for (Comment comment : commentList) {
            System.out.println(comment.toString());
        }
    }

    @Test
    public void testGetCommentListForBoard() {
        List<Comment> commentList = commentRepository.findCommentsBySeqOrderByRegDateDesc(1L);
        for (Comment comment : commentList) {
            System.out.println(comment.toString());
        }
    }
}