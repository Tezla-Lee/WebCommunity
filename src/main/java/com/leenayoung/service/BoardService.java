package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;

import java.util.List;

public interface BoardService {
    void insertBoard(Board board);

    void deleteBoard(Board board);

    Board updateBoard(Board board);

    Board getBoard(Board board);

    Board updateBoardCount(Board board);

    List<Board> getBoardList();

    List<Board> getBoardListByTitle(String title);

    List<Board> getBoardListByUser_ID(String writer);

    List<Board> getBoardListByCommunity_Seq(Community community);

    List<Board> getBoardListByContent(String content);

    List<Board> getBoardListByCommunity_Name(String name);

    List<Board> getBoardListByTitleAndCommunitySeq(String title, long communitySeq);

    List<Board> getBoardListByContentAndCommunitySeq(String content, long communitySeq);

    List<Board> getBoardListByUserIDAndCommunitySeq(String userId, long communitySeq);
}
