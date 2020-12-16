package com.leenayoung.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString(exclude = "board")
public class Comment {

    @Id
    @GeneratedValue
    private long seq;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOARD_SEQ", nullable = false)
    private Board board;

    //    @Column(insertable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date regDate;

    public void setBoard(Board board) {
        this.board = board;
//        board.getCommentList().add(this);
    }
}