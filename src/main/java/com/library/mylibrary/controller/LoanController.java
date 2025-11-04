package com.library.mylibrary.controller;

import com.library.mylibrary.model.Loan;
import com.library.mylibrary.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/api/book/loan/lend")
    public ResponseEntity<?> lendBook(@RequestBody Loan loan, Principal principal){
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.lendBook(loan, principal.getName()));
    }

    @PutMapping("/api/book/loan/return")
    public ResponseEntity<?> returnBook(int bookId){
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.returnBook(bookId));
    }
}
