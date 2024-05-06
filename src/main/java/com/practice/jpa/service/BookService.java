package com.practice.jpa.service;

import com.practice.jpa.entity.Book;
import com.practice.jpa.entity.Review;
import com.practice.jpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public void reviewSave(Review review) {
        bookRepository.reviewSave(review);
    }
}
