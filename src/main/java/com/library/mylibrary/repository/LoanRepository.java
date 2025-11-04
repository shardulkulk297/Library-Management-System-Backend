package com.library.mylibrary.repository;

import com.library.mylibrary.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    @Query("Select l from Loan l WHERE l.book.id = ?1")
    Loan getLoanedBook(int bookId);
}
