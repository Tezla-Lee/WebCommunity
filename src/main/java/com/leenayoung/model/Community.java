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
    private Long number;

    @Column(name="COMMUNITY_NAME", nullable = false)
    private String name;
}
