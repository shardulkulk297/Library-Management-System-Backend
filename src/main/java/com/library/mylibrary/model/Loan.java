package com.library.mylibrary.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
public class Loan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Book book;
    private LocalDateTime loanedAt = LocalDateTime.now();
    private LocalDateTime returnedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getLoanedAt() {
        return loanedAt;
    }

    public void setLoanedAt(LocalDateTime loanedAt) {
        this.loanedAt = loanedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }
}
