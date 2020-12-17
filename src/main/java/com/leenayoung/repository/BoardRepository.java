package com.leenayoung.repository;

import com.leenayoung.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findBoardByTitleContaining(String keyword);

    Page<Board> findBoardByTitleContaining(String keyword, Pageable pageable);

    List<Board> findBoardByContentContaining(String keyword);

    Page<Board> findBoardByContentContaining(String keyword, Pageable pageable);

    List<Board> findBoardByUser_IdContaining(String keyword);

    Page<Board> findBoardByUser_Id(String keyword, Pageable pageable);


    List<Board> findBoardByCommunity_Seq(long seq);

    List<Board> findBoardByCommunity_Name(String name);

    Page<Board> findBoardByCommunity_Name(String name, Pageable pageable);

    Page<Board> findBoardByCommunity_Seq(long seq, Pageable pageable);

    Page<Board> findAll(Pageable pageable);


    @Query("select b from Board as b where b.title like %:title% and b.community.seq = :seq ")
    List<Board> findBoardByTitleAndCommunitySeq(String title, long seq);

    @Query("select b from Board as b where b.content like %:content% and b.community.seq = :seq ")
    List<Board> findBoardByContentAndCommunitySeq(String content, long seq);

    @Query("select b from Board as b where b.user.id = :userId and b.community.seq = :seq ")
    List<Board> findBoardByUser_IDAndCommunitySeq(String userId, long seq);

    @Query("select b from Board as b where b.title like %:title% and b.community.seq = :seq ")
    Page<Board> findBoardByTitleAndCommunitySeq(String title, long seq, Pageable pageable);

    @Query("select b from Board as b where b.content like %:content% and b.community.seq = :seq ")
    Page<Board> findBoardByContentAndCommunitySeq(String content, long seq, Pageable pageable);

    @Query("select b from Board as b where b.user.id = :userId and b.community.seq = :seq ")
    Page<Board> findBoardByUser_IDAndCommunitySeq(String userId, long seq, Pageable pageable);


}
