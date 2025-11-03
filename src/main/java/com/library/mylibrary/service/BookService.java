package com.library.mylibrary.service;

import com.library.mylibrary.model.Author;
import com.library.mylibrary.model.Book;
import com.library.mylibrary.repository.AuthorRepository;
import com.library.mylibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public final AuthorRepository authorRepository;
    public final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        Author author = book.getAuthor();
        Author authorToCheck = authorRepository.getByUsername(author.getUser().getUsername());
        if(authorToCheck!=null){
            book.setAuthor(author);
        }
        else{
            author = authorRepository.save(author);
            book.setAuthor(author);
        }
        return bookRepository.save(book);
    }

    public Book getBook(int bookId) {
        return bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("Book Not Found"));
    }

    public List<Book> searchBook(String title) {
        return bookRepository.searchBook(title);
    }


    public Book updateBook(Book book) {
        return null;
    }

    public String deleteBook(int bookId){

        Book book = getBook(bookId);
        bookRepository.delete(book);
        return "Deleted Successfully";
    }
}
