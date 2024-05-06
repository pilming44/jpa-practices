package com.practice.jpa.service;

import com.practice.jpa.entity.Publisher;
import com.practice.jpa.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    @Transactional
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public Publisher findOne(Long id) {
        return publisherRepository.findOne(id);
    }

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }
}
