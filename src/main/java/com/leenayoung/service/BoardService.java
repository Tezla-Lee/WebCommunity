package com.leenayoung.service;

import com.leenayoung.model.Board;

import java.util.List;

public interface BoardService {
    void insertBoard(Board board);

    void deleteBoard(Board board);

    void updateBoard(Board board);

    Board getBoard(Board board);

    List<Board> getBoardList(Board board);

}
