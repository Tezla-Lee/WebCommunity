package com.leenayoung;

import com.leenayoung.model.Board;
import com.leenayoung.model.Comment;
import com.leenayoung.repository.BoardRepository;
import com.leenayoung.repository.CommentRepository;
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

    @Test
    public void oneToManyInsertTest() {
        Board board = new Board();
        board.setTitle("매핑 테스트 1");
        board.setWriter("나영원");

        for (int i = 0; i < 3; i++) {
            Comment comment = new Comment();
            comment.setBoard(board);

        }
    }
}
