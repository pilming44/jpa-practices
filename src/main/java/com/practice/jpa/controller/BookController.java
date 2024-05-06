package com.practice.jpa.controller;

import com.practice.jpa.service.AuthorService;
import com.practice.jpa.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BookController {
    private final AuthorService authorService;
    private final PublisherService publisherService;

    @GetMapping("/books/new")
    public String registerBookForm(Model model) {
        log.info("책 등록 폼");
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        return "books/registerBookForm";
    }

    @GetMapping("/books")
    public String list() {
        log.info("책 목록");
        return "books/booksList";
    }
}
