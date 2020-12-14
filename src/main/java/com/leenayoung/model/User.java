package com.leenayoung.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    @Column(unique = true)
    String id;

    @Column(nullable = false)
    String password;

    @Column(updatable = false, nullable = false)
    String name;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date joinDate;

    @Column(nullable = false)
    String role;


}
