package com.practice.jpa.controller;

import com.practice.jpa.controller.form.AuthorForm;
import com.practice.jpa.entity.Author;
import com.practice.jpa.entity.Book;
import com.practice.jpa.service.AuthorService;
import com.practice.jpa.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

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

    @GetMapping("/authors/{id}")
    public String authorDetail(@PathVariable(name = "id") Long authorId, Model model) {
        log.info("저자상세");
        Author author = authorService.findOne(authorId);
        List<Book> bookByAuthorId = bookService.findBookByAuthorId(authorId);
        model.addAttribute("author", author);
        model.addAttribute("authorBook", bookByAuthorId);
        return "authors/authorDetail";
    }
}
