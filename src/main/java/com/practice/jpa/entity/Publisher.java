package com.practice.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue
    @Column(name = "publisher_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList = new ArrayList<>();

    public Publisher(String name) {
        this.name = name;
    }
}
