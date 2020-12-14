package com.leenayoung.service;

import com.leenayoung.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {

    @Autowired
    CommentService commentService;

    @Test
    public void insertComment() {
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setContent("댓글 테스트 " + i);
            comment.setSeq(1);
            comment.setWriter("댓글 테스터 " + i);
            commentService.insertComment(comment);
        }
    }

    @Test
    public void deleteComment() {
    }

    @Test
    public void updateComment() {
    }

    @Test
    public void getCommentList() {
    }
}