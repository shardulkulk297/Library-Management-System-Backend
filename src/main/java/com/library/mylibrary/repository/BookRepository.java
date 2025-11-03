package com.library.mylibrary.repository;

import com.library.mylibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("Select b from Book b WHERE b.title = ?1")
    List<Book> searchBook(String title);
}
