package com.practice.jpa.repository;

import com.practice.jpa.entity.Book;
import com.practice.jpa.entity.Review;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final EntityManager em;

    public void save(Book book) {
        em.persist(book);
    }

    public Book findOne(Long id) {
        return em.find(Book.class, id);
    }

    public List<Book> findAll() {
        return em.createQuery("select b from Book b order by b.publishedDate desc", Book.class)
                .getResultList();
    }

    public void reviewSave(Review review) {
        em.persist(review);
    }

    public List<Book> findByAuthorId(Long authorId) {
        return em.createQuery("select b from Book b where b.author.id = :authorId order by b.publishedDate desc", Book.class)
                .setParameter("authorId", authorId)
                .getResultList();
    }
}
