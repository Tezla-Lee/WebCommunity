package com.leenayoung.repository;

import com.leenayoung.model.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findBoardByTitleContaining(String keyword);

    List<Board> findBoardByContentContaining(String keyword);

    List<Board> findBoardByUser_IdContaining(String keyword);

    List<Board> findBoardByCommunity_Seq(long seq);

    List<Board> findBoardByCommunity_Name(String name);

    @Query("select b from Board as b where b.title like %:title% and b.community.seq = :seq ")
    List<Board> findBoardByTitleAndCommunitySeq(String title, long seq);

    @Query("select b from Board as b where b.content like %:content% and b.community.seq = :seq ")
    List<Board> findBoardByContentAndCommunitySeq(String content, long seq);

    @Query("select b from Board as b where b.user.id = :userId and b.community.seq = :seq ")
    List<Board> findBoardByUser_IDAndCommunitySeq(String userId, long seq);
}
