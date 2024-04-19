package com.practice.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PublisherController {
    @GetMapping("/publishers/new")
    public String registerpublisherFrom() {
        log.info("출판사 등록 폼");
        return "publishers/registerPublisherForm";
    }
}
