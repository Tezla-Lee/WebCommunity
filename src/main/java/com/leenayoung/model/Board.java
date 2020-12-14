package com.leenayoung.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue
    private Long seq;

    private String title;

    @Column(updatable = false)
//    @JoinColumn(name = "USER_ID", nullable = false)
    private String writer;

    private String content;

    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column(insertable = false, updatable = false)
    private long cnt;

//    @JoinColumn(name = "CATEGORY_NAME", nullable = false)
    private String category;
}
