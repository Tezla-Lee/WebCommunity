package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import com.leenayoung.model.User;
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

    @Autowired
    CommunityService communityService;

    @Autowired
    UserService userService;

    @Test
    public void testInsertBoard() {
        Community community = new Community();
        community.setName("ani");

        User user = new User();
        user.setId("user1");

        for (int i = 0; i < 10; i++) {
            Board board = new Board();
            board.setTitle("insertBoard Test : " + i);
            board.setContent("test content : " + i);
            board.setCommunity(communityService.getCommunity(community));
            board.setUser(userService.getUser(user));
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