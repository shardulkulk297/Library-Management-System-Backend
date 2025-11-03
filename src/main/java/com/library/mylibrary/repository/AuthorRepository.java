package com.library.mylibrary.repository;

import com.library.mylibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("Select a from Author a WHERE a.user.username=?1")
    Author getByUsername(String name);
}
