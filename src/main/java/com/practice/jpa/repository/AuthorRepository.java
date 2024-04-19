package com.practice.jpa.repository;

import com.practice.jpa.entity.Author;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthorRepository {

    private final EntityManager em;

    public void save(Author author) {
        em.persist(author);
    }

    public Author findOne(Long id) {
        return em.find(Author.class, id);
    }
}
