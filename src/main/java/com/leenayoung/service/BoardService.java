package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;

import java.util.List;

public interface BoardService {
    void insertBoard(Board board);

    void deleteBoard(Board board);

    void updateBoard(Board board);

    Board getBoard(Board board);

    List<Board> getBoardList(Board board);

    List<Board> getBoardListByTitle(String title);

    List<Board> getBoardListByUser_ID(String writer);

    List<Board> getBoardListByCommunity_Seq(Community community);

}
