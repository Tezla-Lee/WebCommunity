package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import com.leenayoung.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Board updateBoard(Board board) {
        System.out.println("===> updateBoard ....................");
        Board updateBoard = boardRepository.findById(board.getSeq()).get();
        System.out.println(updateBoard.toString());
        updateBoard.setTitle(board.getTitle());
        updateBoard.setContent(board.getContent());
        updateBoard.setCnt(board.getCnt());
        updateBoard.setRegDate(new Date());
        System.out.println(updateBoard.toString());
        boardRepository.save(updateBoard);
        return updateBoard;
    }

    @Override
    public Board getBoard(Board board) {
        System.out.println("===> getBoard................");
        return boardRepository.findById(board.getSeq()).get();
    }

    @Override
    public Board updateBoardCount(Board board) {
        board.setCnt(board.getCnt() + 1);
        boardRepository.save(board);
        return board;
    }

    @Override
    public List<Board> getBoardList() {
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
    public List<Board> getBoardListByCommunity_Seq(Community community) {
        return boardRepository.findBoardByCommunity_Seq(community.getSeq());
    }

    @Override
    public List<Board> getBoardListByContent(String content) {
        return boardRepository.findBoardByContentContaining(content);
    }

    @Override
    public List<Board> getBoardListByCommunity_Name(String name) {
        return boardRepository.findBoardByCommunity_Name(name);
    }

    @Override
    public List<Board> getBoardListByTitleAndCommunitySeq(String title, long communitySeq) {
        return boardRepository.findBoardByTitleAndCommunitySeq(title, communitySeq);
    }

    @Override
    public List<Board> getBoardListByContentAndCommunitySeq(String content, long communitySeq) {
        return boardRepository.findBoardByContentAndCommunitySeq(content, communitySeq);
    }

    @Override
    public List<Board> getBoardListByUserIDAndCommunitySeq(String userId, long communitySeq) {
        return boardRepository.findBoardByUser_IDAndCommunitySeq(userId, communitySeq);
    }
}
