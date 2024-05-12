package com.practice.jpa;

import com.practice.jpa.entity.Author;
import com.practice.jpa.entity.Book;
import com.practice.jpa.entity.Publisher;
import com.practice.jpa.enums.BookStatus;
import com.practice.jpa.service.AuthorService;
import com.practice.jpa.service.BookService;
import com.practice.jpa.service.PublisherService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("local")
public class InitData {
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final BookService bookService;

    @PostConstruct
    public void init() {
        Author author1 = new Author("최재현");
        Author author2 = new Author("방서현");
        authorService.saveAuthor(author1);
        authorService.saveAuthor(author2);

        Publisher publisher1 = new Publisher("화성시");
        Publisher publisher2 = new Publisher("수원시");
        publisherService.save(publisher1);
        publisherService.save(publisher2);

        Book book1 = new Book("최재현 책", author1, publisher1, BookStatus.AVAILABLE_FOR_RENT);
        Book book2 = new Book("방서현 책", author2, publisher2, BookStatus.PLANNED_TO_PURCHASE);
        Book book3 = new Book("최재현 책2", author1, publisher2, BookStatus.PLANNED_TO_PURCHASE);
        Book book4 = new Book("부에노 책", author1, publisher1, BookStatus.UNAVAILABLE_FOR_RENT);
        Book book5 = new Book("오월의 숲 책", author2, publisher2, BookStatus.AVAILABLE_FOR_RENT);
        Book book6 = new Book("에이게이트 책", author2, publisher1, BookStatus.UNAVAILABLE_FOR_RENT);
        Book book7 = new Book("홈카페 책", author1, publisher1, BookStatus.PLANNED_TO_PURCHASE);
        Book book8 = new Book("책", author2, publisher2, BookStatus.AVAILABLE_FOR_RENT);
        Book book9 = new Book("시골책", author2, publisher1, BookStatus.PLANNED_TO_PURCHASE);
        Book book10 = new Book("천안책", author1, publisher2, BookStatus.AVAILABLE_FOR_RENT);
        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
        bookService.save(book4);
        bookService.save(book5);
        bookService.save(book6);
        bookService.save(book7);
        bookService.save(book8);
        bookService.save(book9);
        bookService.save(book10);
    }
}
