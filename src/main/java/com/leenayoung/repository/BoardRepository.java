package com.leenayoung.repository;

import com.leenayoung.model.Board;
import com.leenayoung.model.Community;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findBoardByTitleContaining(String keyword);

    List<Board> findBoardByContentContaining(String keyword);

    List<Board> findBoardByUser_IdContaining(String keyword);

    List<Board> findBoardByCommunity(Community community);
}
