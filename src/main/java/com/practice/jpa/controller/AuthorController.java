package com.practice.jpa.controller;

import com.practice.jpa.controller.form.AuthorForm;
import com.practice.jpa.entity.Author;
import com.practice.jpa.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping("/authors/new")
    public String registerAuthorForm() {
        log.info("저자등록 폼");
        return "authors/registerAuthorForm";
    }

    @PostMapping("/authors/new")
    public String registerAuthor(AuthorForm authorForm) {
        log.info("저자등록 post");
        authorService.saveAuthor(new Author(authorForm.getName()));
        return "redirect:/";
    }
}
