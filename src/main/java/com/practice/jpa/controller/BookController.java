package com.practice.jpa.controller;

import com.practice.jpa.controller.form.BookForm;
import com.practice.jpa.controller.form.ReviewForm;
import com.practice.jpa.entity.Author;
import com.practice.jpa.entity.Book;
import com.practice.jpa.entity.Publisher;
import com.practice.jpa.entity.Review;
import com.practice.jpa.enums.BookStatus;
import com.practice.jpa.service.AuthorService;
import com.practice.jpa.service.BookService;
import com.practice.jpa.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BookController {
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final BookService bookService;

    @GetMapping("/books/new")
    public String registerBookForm(Model model) {
        log.info("책 등록 폼");
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("bookStatus", Arrays.asList(BookStatus.values()));
        return "books/registerBookForm";
    }

    @PostMapping("/books/new")
    public String registerBook(BookForm bookForm) {
        log.info("책 등록");
        Author author = authorService.findOne(bookForm.getAuthorId());
        Publisher publisher = publisherService.findOne(bookForm.getPublisherId());
        bookService.save(new Book(bookForm.getTitle(), author, publisher, bookForm.getStatus()));
        return "redirect:/";
    }

    @GetMapping("/books")
    public String list(Model model) {
        log.info("책 목록");
        model.addAttribute("books", bookService.findAll());
        return "books/booksList";
    }

    @GetMapping("/books/{id}")
    public String bookDetail(@PathVariable("id") Long bookId, Model model) {
        log.info("책 상세조회");
        model.addAttribute("book", bookService.findOne(bookId));
        return "books/bookDetail";
    }

    @PostMapping("/books/{id}/review")
    public String registerBookReview(@PathVariable("id") Long bookId, ReviewForm reviewForm) {
        log.info("책 리뷰 등록");
        Book book = bookService.findOne(bookId);
        Review review = new Review(book, reviewForm.getComment());
        bookService.reviewSave(review);
        return "redirect:/books/" + bookId;
    }

    @GetMapping("/books/update/{id}")
    public String modifyBookForm(@PathVariable("id") Long bookId, Model model) {
        log.info("책 수정 폼");
        model.addAttribute("book", bookService.findOne(bookId));
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("bookStatus", Arrays.asList(BookStatus.values()));
        return "books/modifyBookForm";
    }

    @PostMapping("/books/update/{id}")
    public String modifyBook(@PathVariable("id") Long bookId, BookForm bookForm) {
        log.info("책 수정");
        bookService.update(bookId, bookForm);
        return "redirect:/books/" + bookId;
    }
}
