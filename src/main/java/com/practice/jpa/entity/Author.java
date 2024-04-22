package com.practice.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Biography> biographyList = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }
}
