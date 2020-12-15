package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import com.leenayoung.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void insertBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepository.deleteById(board.getSeq());
    }

    @Override
    public void updateBoard(Board board) {
        Board newBoard = boardRepository.findById(board.getSeq()).get();
        newBoard.setTitle(board.getTitle());
        newBoard.setContent(board.getContent());
        newBoard.setCnt(board.getCnt());
        newBoard.setCommunity(board.getCommunity());
        boardRepository.save(newBoard);
    }

    @Override
    public Board getBoard(Board board) {
        return boardRepository.findById(board.getSeq()).get();
    }

    @Override
    public List<Board> getBoardList(Board board) {
        return (List<Board>) boardRepository.findAll();
    }

    @Override
    public List<Board> getBoardListByTitle(String title) {
        return boardRepository.findBoardByTitleContaining(title);
    }

    @Override
    public List<Board> getBoardListByUser_ID(String userID) {
        return boardRepository.findBoardByUser_IdContaining(userID);
    }

    @Override
    public List<Board> getBoardList(Community community) {
        return boardRepository.findBoardByCommunity(community);
    }
}
