package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Comment;
import com.leenayoung.model.User;
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

    @Autowired
    UserService userService;

    @Autowired
    BoardService boardService;


    @Test
    public void insertComment() {
        User user = new User();
        user.setId("user1");
        user = userService.getUser(user);

        Board board = new Board();
        board.setSeq(12L);
        board = boardService.getBoard(board);

        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setContent("댓글 테스트 " + i);
            comment.setUser(user);
            comment.setBoard(board);
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