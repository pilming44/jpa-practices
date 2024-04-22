package com.practice.jpa.service;

import com.practice.jpa.entity.Author;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    @DisplayName("저자 등록")
        //@Rollback(value = false)
    void 저자등록() {
        //given
        Author author = new Author("최재현");
        //when
        authorService.saveAuthor(author);
        //then
        Assertions.assertThat(author).isEqualTo(authorService.findAuthor(author.getId()));
    }

    @Test
    @DisplayName("저자 상세조회")
    void 저자상세조회() {
        // given
        Author author = new Author("최재현");
        authorService.saveAuthor(author);
        // when
        Author author1 = authorService.findAuthor(author.getId());
        // then
        Assertions.assertThat(author1).isEqualTo(author);
    }
}