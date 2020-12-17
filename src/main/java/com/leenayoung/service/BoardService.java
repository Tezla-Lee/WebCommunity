package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    void insertBoard(Board board);

    void deleteBoard(Board board);

    Board updateBoard(Board board);

    Board getBoard(Board board);

    Board updateBoardCount(Board board);

    List<Board> getBoardList();

    List<Board> getBoardListByTitle(String title);

    Page<Board> getBoardListByTitle(String title, Pageable pageable);

    List<Board> getBoardListByUser_ID(String writer);

    Page<Board> getBoardListByUser_ID(String writer, Pageable pageable);

    List<Board> getBoardListByCommunity_Seq(Community community);

    List<Board> getBoardListByContent(String content);

    Page<Board> getBoardListByContent(String content, Pageable pageable);

    List<Board> getBoardListByCommunity_Name(String name);

    Page<Board> getBoardListByCommunity_Name(String name, Pageable pageable);

    List<Board> getBoardListByTitleAndCommunitySeq(String title, long communitySeq);

    Page<Board> getBoardListByTitleAndCommunitySeq(String title, long communitySeq, Pageable pageable);

    List<Board> getBoardListByContentAndCommunitySeq(String content, long communitySeq);

    Page<Board> getBoardListByContentAndCommunitySeq(String content, long communitySeq, Pageable pageable);

    List<Board> getBoardListByUserIDAndCommunitySeq(String userId, long communitySeq);

    Page<Board> getBoardListByUserIDAndCommunitySeq(String userId, long communitySeq, Pageable pageable);

    Page<Board> getBoardByCommunity_Seq(long seq, Pageable pageable);

    Page<Board> getBoardListPage(Pageable pageable);
}
