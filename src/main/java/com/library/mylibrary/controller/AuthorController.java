package com.library.mylibrary.controller;

import com.library.mylibrary.model.Author;
import com.library.mylibrary.model.Book;
import com.library.mylibrary.service.AuthorService;
import com.library.mylibrary.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    public final BookService bookService;
    public final AuthorService authorService;

    public AuthorController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<?> addAuthor(@RequestBody Author author){

        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.addAuthor(author));

    }




}
