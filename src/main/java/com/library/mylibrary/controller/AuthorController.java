package com.library.mylibrary.controller;

import com.library.mylibrary.model.Author;
import com.library.mylibrary.model.Book;
import com.library.mylibrary.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    public final BookService bookService;

    public AuthorController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/api/book/create")
    public ResponseEntity<?> createBook(@RequestBody Book book)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
    }
}
