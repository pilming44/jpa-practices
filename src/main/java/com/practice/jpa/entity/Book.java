package com.practice.jpa.entity;

import com.practice.jpa.enums.BookStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Column(name = "published_date")
    private LocalDateTime publishedDate = LocalDateTime.now();

    @OneToMany(mappedBy = "book")
    private List<Review> reviewList = new ArrayList<>();

    public Book(String title, Author author, Publisher publisher, BookStatus status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.status = status;
    }
}
