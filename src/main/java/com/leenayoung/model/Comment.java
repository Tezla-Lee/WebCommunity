package com.leenayoung.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private long number;

    @JoinColumn(name = "USER_ID", nullable = false)
    private String writer;

    private String content;

//    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOARD_SEQ", nullable = false)
    private long seq;

//    @Column(insertable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date regDate;

}