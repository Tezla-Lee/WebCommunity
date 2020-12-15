package com.leenayoung.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "BOARD_SEQ")
    private Long seq;

    private String title;

    @Column(updatable = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private String writer;

    private String content;

    //    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date regDate;

    @Column(insertable = false, updatable = false)
    @ColumnDefault("0")
    private long cnt;

    @JoinColumn(name = "CATEGORY_NAME", nullable = false)
    private String category;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();
}
