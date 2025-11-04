package com.library.mylibrary.service;

import com.library.mylibrary.model.Loan;
import com.library.mylibrary.model.Member;
import com.library.mylibrary.repository.LoanRepository;
import com.library.mylibrary.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoanService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LoanRepository loanRepository;
    public Loan lendBook(Loan loan, String username) {
        Member member = memberRepository.getByUsername(username);
        loan.setMember(member);
        return loanRepository.save(loan);
    }

    public Loan returnBook(int bookId) {
        Loan loan = loanRepository.getLoanedBook(bookId);
        loan.setReturnedAt(LocalDateTime.now());
        return loanRepository.save(loan);
    }
}
