package com.leenayoung.service;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import com.leenayoung.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Board> getBoardListByTitle(String title, Pageable pageable) {
        return boardRepository.findBoardByTitleContaining(title, pageable);
    }

    @Override
    public List<Board> getBoardListByUser_ID(String userID) {
        return boardRepository.findBoardByUser_IdContaining(userID);
    }

    @Override
    public Page<Board> getBoardListByUser_ID(String writer, Pageable pageable) {
        return boardRepository.findBoardByUser_Id(writer, pageable);
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
    public Page<Board> getBoardListByContent(String content, Pageable pageable) {
        return boardRepository.findBoardByContentContaining(content, pageable);
    }

    @Override
    public List<Board> getBoardListByCommunity_Name(String name) {
        return boardRepository.findBoardByCommunity_Name(name);
    }

    @Override
    public Page<Board> getBoardListByCommunity_Name(String name, Pageable pageable) {
        return boardRepository.findBoardByCommunity_Name(name, pageable);
    }

    @Override
    public List<Board> getBoardListByTitleAndCommunitySeq(String title, long communitySeq) {
        return boardRepository.findBoardByTitleAndCommunitySeq(title, communitySeq);
    }

    @Override
    public Page<Board> getBoardListByTitleAndCommunitySeq(String title, long communitySeq, Pageable pageable) {
        return boardRepository.findBoardByTitleAndCommunitySeq(title, communitySeq, pageable);
    }

    @Override
    public List<Board> getBoardListByContentAndCommunitySeq(String content, long communitySeq) {
        return boardRepository.findBoardByContentAndCommunitySeq(content, communitySeq);
    }

    @Override
    public Page<Board> getBoardListByContentAndCommunitySeq(String content, long communitySeq, Pageable pageable) {
        return boardRepository.findBoardByContentAndCommunitySeq(content, communitySeq, pageable);
    }

    @Override
    public List<Board> getBoardListByUserIDAndCommunitySeq(String userId, long communitySeq) {
        return boardRepository.findBoardByUser_IDAndCommunitySeq(userId, communitySeq);
    }

    @Override
    public Page<Board> getBoardListByUserIDAndCommunitySeq(String userId, long communitySeq, Pageable pageable) {
        return boardRepository.findBoardByUser_IDAndCommunitySeq(userId, communitySeq, pageable);
    }

    @Override
    public Page<Board> getBoardByCommunity_Seq(long seq, Pageable pageable) {
        return boardRepository.findBoardByCommunity_Seq(seq, pageable);
    }

    @Override
    public Page<Board> getBoardListPage(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
