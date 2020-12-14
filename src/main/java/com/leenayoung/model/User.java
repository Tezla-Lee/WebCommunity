package com.leenayoung.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    @Column(unique = true, updatable = false)
    String id;

    @Column(nullable = false)
    String password;

    @Column(updatable = false, nullable = false)
    String name;

    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
//    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
//    @ColumnDefault("sysdate")
    Date joinDate;


    @Column(nullable = false)
    String role;


}
