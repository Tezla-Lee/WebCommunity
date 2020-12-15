package com.leenayoung;

import com.leenayoung.model.Board;
import com.leenayoung.model.Comment;
import com.leenayoung.model.User;
import com.leenayoung.repository.BoardRepository;
import com.leenayoung.repository.CommentRepository;
import com.leenayoung.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void oneToManyInsertTest() {
        User user = new User();
        user.setId("테스트 id");
        user.setPassword("테스트 pw");
        user.setName("유저 이름");
        user.setRole("ADMIN");
        userRepository.save(user);

        Board board = new Board();
        board.setTitle("매핑 테스트 1");
        board.setUser(user);


        Comment comment = new Comment();
        comment.setBoard(board);
        comment.setContent("댓글 테스트");
        comment.setUser(user);

        boardRepository.save(board);
        System.out.println(board.toString());
        // 흐음
    }
}