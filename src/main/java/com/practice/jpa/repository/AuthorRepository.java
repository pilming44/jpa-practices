package com.practice.jpa.repository;

import com.practice.jpa.entity.Author;
import com.practice.jpa.entity.Book;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Author> findAll() {
        return em.createQuery("select a from Author a", Author.class)
                .getResultList();
    }
}
