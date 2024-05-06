package com.practice.jpa.controller;

import com.practice.jpa.controller.form.PublisherForm;
import com.practice.jpa.entity.Publisher;
import com.practice.jpa.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping("/publishers/new")
    public String registerpublisherForm() {
        log.info("출판사 등록 폼");
        return "publishers/registerPublisherForm";
    }

    @PostMapping("/publishers/new")
    public String registerpublisher(PublisherForm publisherForm) {
        log.info("출판사 등록");
        publisherService.save(new Publisher(publisherForm.getName()));
        return "redirect:/";
    }
}
