package com.practice.jpa.controller;

import com.practice.jpa.controller.form.BookForm;
import com.practice.jpa.entity.Author;
import com.practice.jpa.entity.Book;
import com.practice.jpa.entity.Publisher;
import com.practice.jpa.service.AuthorService;
import com.practice.jpa.service.BookService;
import com.practice.jpa.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "books/registerBookForm";
    }

    @PostMapping("/books/new")
    public String registerBook(BookForm bookForm) {
        log.info("책 등록");
        Author author = authorService.findOne(bookForm.getAuthorId());
        Publisher publisher = publisherService.findOne(bookForm.getPublisherId());
        bookService.save(new Book(bookForm.getTitle(), author, publisher));
        return "redirect:/";
    }

    @GetMapping("/books")
    public String list(Model model) {
        log.info("책 목록");
        model.addAttribute("books", bookService.findAll());
        return "books/booksList";
    }
}
