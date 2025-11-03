package com.library.mylibrary.controller;

import com.library.mylibrary.model.Book;
import com.library.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/api/book/create")
    public ResponseEntity<?> createBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
    }

    @GetMapping("/api/book/get/{bookId}")
    public ResponseEntity<?> getBook(@PathVariable int bookId){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBook(bookId));
    }

    @GetMapping("/api/book/search")
    public ResponseEntity<?> searchBook(@RequestParam String title){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.searchBook(title));
    }

    @PutMapping("/api/book/update")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.updateBook(book));
    }

    @DeleteMapping("/api/book/delete/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBook(bookId));
    }
}
