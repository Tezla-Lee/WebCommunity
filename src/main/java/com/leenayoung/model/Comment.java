package com.leenayoung.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private long number;

//    @JoinColumn(name = "USER_ID", nullable = false)
    private String writer;

    private String content;

//    @JoinColumn(name = "BOARD_SEQ", nullable = false)
    private long seq;

//    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date regDate;

}