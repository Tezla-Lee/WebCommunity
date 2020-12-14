package com.leenayoung.repository;

import com.leenayoung.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void findBoardByTitleContaining() {
        List<Board> boardList = boardRepository.findBoardByTitleContaining("Test");
        for (Board board : boardList) {
            System.out.println(board.toString());
        }
    }

    @Test
    public void findBoardByContentContains() {
        List<Board> boardList = boardRepository.findBoardByContentContaining("test");
        for (Board board : boardList) {
            System.out.println(board.toString());
        }
    }

    @Test
    public void findBoardByWriterContains() {
        List<Board> boardList = boardRepository.findBoardByWriterContaining("Tester");
        for (Board board : boardList) {
            System.out.println(board.toString());
        }
    }
}