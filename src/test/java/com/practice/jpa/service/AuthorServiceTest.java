package com.practice.jpa.service;

import com.practice.jpa.entity.Author;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    //@Rollback(value = false)
    void 저자등록() {
        Author author = new Author("최재현");
        authorService.saveAuthor(author);
        Assertions.assertThat(author).isEqualTo(authorService.findAuthor(author.getId()));
    }
}