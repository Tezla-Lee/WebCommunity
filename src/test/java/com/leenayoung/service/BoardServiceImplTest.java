package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import com.leenayoung.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Autowired
    CommunityService communityService;

    @Autowired
    UserService userService;

    // EntityManager 생성
    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    public void testInsertBoard() {

            User user = new User();
            Community community = new Community();

            for (int i = 0; i < 50; i++) {
                community.setSeq((long) i + 99);
                for (int j = 1; j <= 50; j++) {
                    user.setId("member" + j);
                    Board board = new Board();
                    board.setTitle("새로운 글쓰기 패스트캠퍼스 " + i + " " + j);
                    board.setContent("미니 프로젝트 패스트캠퍼스 테스트 " + i + " " + j);
                    board.setCommunity(communityService.getCommunity(community));
                    board.setUser(userService.getUser(user));
                    boardService.insertBoard(board);
                    em.persist(board); // JPA 컨테이너(Persistence Context)로 객체를 넣어줌. 영속 상태로 만듦. // seq(pk) 가 자동으로 세팅됨. 영속 상태의 객체에 pk(식별자 변수)가 없으면 예외 발생.
                }
            }
            em.flush();
            em.clear();
//            tx1.commit(); // 이 때 실제 DB에 적용 (flush : 쌓여 있는 SQL 을 DB에 보냄)
//        } catch (Exception e) {
//            e.printStackTrace();
//            tx1.rollback(); // commit 때 예외가 발생하면 롤백
//        } finally {
            em.close();
//        }
    }

    @Test
    public void deleteBoard() {
    }

    @Test
    public void updateBoard() {
        Board board = new Board();
        board.setSeq(12L);
        Board updateBoard = boardService.getBoard(board);

        updateBoard.setTitle("update Board");
        updateBoard.setContent("update content");

        boardService.updateBoard(updateBoard);
    }

    @Test
    public void getBoard() {
    }

    @Test
    public void getBoardList() {
    }

    @Test
    public void getBoardListByCommunity_SeqAndPageable() {

        // Board -> commentList EAGER 로 해야 통과함.
        Pageable pageable = PageRequest.of(0, 10);

        Page<Board> pageInfo = boardService.getBoardByCommunity_Seq(1, pageable);

        List<Board> boardList = pageInfo.getContent();

        System.out.println("-------------------------------------------");
        for (Board board : boardList) {
            System.out.println(board.toString());
        }
    }
}