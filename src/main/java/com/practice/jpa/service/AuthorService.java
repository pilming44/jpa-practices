package com.practice.jpa.service;

import com.practice.jpa.entity.Author;
import com.practice.jpa.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author findAuthor(Long authorId) {
        return authorRepository.findOne(authorId);
    }
}
