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

    @JoinColumn(name = "USER_ID", nullable = false)
    @ManyToOne
    private User user;

    private String content;

    //    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date regDate;

    @Column(insertable = false, updatable = false)
    @ColumnDefault("0")
    private long cnt;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_NUMBER")
    private Community category;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();
}