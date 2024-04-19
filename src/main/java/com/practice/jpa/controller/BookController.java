package com.practice.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class BookController {
    @GetMapping("/books/new")
    public String registerBookFrom() {
        log.info("책 등록 폼");
        return "books/registerBookForm";
    }

    @GetMapping("/books")
    public String list() {
        log.info("책 목록");
        return "books/booksList";
    }
}
