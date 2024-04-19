package com.practice.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AuthorController {

    @GetMapping("/authors/new")
    public String registerAuthorFrom() {
        log.info("저자등록 폼");
        return "authors/registerAuthorForm";
    }
}
