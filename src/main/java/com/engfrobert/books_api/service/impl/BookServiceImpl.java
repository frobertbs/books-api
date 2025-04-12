package com.engfrobert.books_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engfrobert.books_api.domain.Book;
import com.engfrobert.books_api.domain.BookEntity;
import com.engfrobert.books_api.repository.BookRepository;
import com.engfrobert.books_api.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    
    @Override
    public Book create(Book book) {
        BookEntity bookEntity = bookToBookEntity(book);
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return bookEntityToBook(savedBookEntity);
    }

    private BookEntity bookToBookEntity(Book book) {
        return BookEntity.builder()
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .title(book.getTitle())
                .build();
    }

    private Book bookEntityToBook(BookEntity bookEntity) {
        return Book.builder()
                .isbn(bookEntity.getIsbn())
                .author(bookEntity.getAuthor())
                .title(bookEntity.getTitle())
                .build();
    }

}
