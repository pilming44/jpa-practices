package com.practice.jpa.repository;

import com.practice.jpa.entity.Publisher;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
