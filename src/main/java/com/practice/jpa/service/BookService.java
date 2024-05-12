package com.practice.jpa.service;

import com.practice.jpa.controller.form.BookForm;
import com.practice.jpa.entity.Author;
import com.practice.jpa.entity.Book;
import com.practice.jpa.entity.Publisher;
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
    private final AuthorService authorService;
    private final PublisherService publisherService;

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

    public List<Book> findBookByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    @Transactional
    public void update(Long id, BookForm bookForm) {
        Author author = authorService.findOne(bookForm.getAuthorId());
        Publisher publisher = publisherService.findOne(bookForm.getPublisherId());

        Book book = bookRepository.findOne(id);

        book.changeTitle(bookForm.getTitle());
        book.changeAuthor(author);
        book.changePublisher(publisher);
        book.changeStatus(bookForm.getStatus());
    }
}
