package com.practice.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private String comment;

    @Column(name = "comment_date")
    private LocalDateTime commentDate = LocalDateTime.now();

    public Review(Book book, String comment) {
        this.book = book;
        this.comment = comment;
    }
}
