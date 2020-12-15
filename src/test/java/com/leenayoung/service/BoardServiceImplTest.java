package com.leenayoung.service;

import com.leenayoung.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Test
    public void testInsertBoard() {
        for (int i = 0; i < 10; i++) {
            Board board = new Board();
            board.setTitle("insertBoard Test : " + i);
//            board.setWriter("Tester : " + i);
            board.setContent("test content : " + i);
//            board.setCommunity("카테고리");

            boardService.insertBoard(board);
        }
    }

    @Test
    public void deleteBoard() {
    }

    @Test
    public void updateBoard() {
    }

    @Test
    public void getBoard() {
    }

    @Test
    public void getBoardList() {
    }
}