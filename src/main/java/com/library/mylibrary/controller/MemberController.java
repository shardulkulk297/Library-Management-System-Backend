package com.library.mylibrary.controller;

import com.library.mylibrary.model.Member;
import com.library.mylibrary.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/api/member/add")
    public ResponseEntity<?> addMember(@RequestBody Member member){
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.add(member));
    }
}
