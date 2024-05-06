package com.practice.jpa.repository;

import com.practice.jpa.entity.Publisher;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PublisherRepository {
    private final EntityManager em;

    public void save(Publisher publisher) {
        em.persist(publisher);
    }

    public Publisher findOne(Long id) {
        return em.find(Publisher.class, id);
    }

    public List<Publisher> findAll() {
        return em.createQuery("select p from Publisher p", Publisher.class)
                .getResultList();
    }
}
