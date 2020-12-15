package com.leenayoung.repository;

import com.leenayoung.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface
CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findCommentsBySeqOrderByRegDate(long seq);
}
