package com.leenayoung.model;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Community {

    @Id
    @GeneratedValue
    @Column(name="COMMUNITY_NUMBER")
    private Long seq;

    @Column(nullable = false)
    private String name;
}
