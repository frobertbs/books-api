package com.engfrobert.books_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.engfrobert.books_api.domain.Book;
import com.engfrobert.books_api.service.BookService;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.create(book);
        return ResponseEntity.ok(createdBook);
    }
}



// DTO - Only used in the controller
// Book - Used in the service
// BookEntity - Used in the repository


