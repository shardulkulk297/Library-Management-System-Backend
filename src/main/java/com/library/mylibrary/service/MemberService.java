package com.library.mylibrary.service;

import com.library.mylibrary.model.Member;
import com.library.mylibrary.model.User;
import com.library.mylibrary.repository.MemberRepository;
import com.library.mylibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MemberRepository memberRepository;

    public Member add(Member member) {
        User user = member.getUser();
        user = userRepository.save(user);
        member.setUser(user);
        return memberRepository.save(member);
    }
}
