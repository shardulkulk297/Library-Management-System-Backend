package com.library.mylibrary.service;

import com.library.mylibrary.model.Author;
import com.library.mylibrary.model.Book;
import com.library.mylibrary.repository.AuthorRepository;
import com.library.mylibrary.repository.BookRepository;

public class BookService {

    public final AuthorRepository authorRepository;
    public final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    public Book createBook(Book book) {
        Author author = book.getAuthor();
        author = authorRepository.save(author);
        book.setAuthor(author);
        return bookRepository.save(book);
    }
}
