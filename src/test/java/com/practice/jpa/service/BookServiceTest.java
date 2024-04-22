package com.practice.jpa.service;

import com.practice.jpa.entity.Author;
import com.practice.jpa.entity.Book;
import com.practice.jpa.entity.Publisher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class BookServiceTest {
    @Autowired private BookService bookService;
    @Autowired private AuthorService authorService;
    @Autowired private PublisherService publisherService;

    @Test
    @DisplayName("책 등록")
    void 책등록() {
        // given
        Book book = registerBook("최재현", "조암", "최재현 책");
        // when
        bookService.save(book);

        // then
        Assertions.assertThat(bookService.findOne(book.getId())).isEqualTo(book);
    }

    @Test
    @DisplayName("책 상세조회")
    void 책상세조회() {
        // given
        Book book = registerBook("최재현", "조암", "최재현 책");
        bookService.save(book);
        // when
        Book findBook = bookService.findOne(book.getId());

        // then
        Assertions.assertThat(findBook).isEqualTo(book);
    }

    @Test
    @DisplayName("책 목록조회")
    void 책목록조회() {
        // given
        Book book1 = registerBook("최재현", "화성시", "화성시의 최재현");
        Book book2 = registerBook("최재현", "수원시", "수원시의 최재현");
        Book book3 = registerBook("삼성", "천안시", "천안시의 최재현");
        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);

        // when
        List<Book> all = bookService.findAll();

        // then
        Assertions.assertThat(all).hasSize(3);
        Assertions.assertThat(all).containsExactlyInAnyOrder(book1, book2, book3);
    }

    private Book registerBook(String authorName, String publisherName, String title) {
        Author author = new Author(authorName);
        authorService.saveAuthor(author);
        Publisher publisher = new Publisher(publisherName);
        publisherService.save(publisher);

        return new Book(title, author, publisher);
    }
}