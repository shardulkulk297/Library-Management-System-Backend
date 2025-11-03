package com.library.mylibrary.service;

import com.library.mylibrary.model.Author;
import com.library.mylibrary.model.Member;
import com.library.mylibrary.model.User;
import com.library.mylibrary.repository.AuthorRepository;
import com.library.mylibrary.repository.MemberRepository;
import com.library.mylibrary.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private AuthorRepository authorRepository;
    private MemberRepository memberRepository;



    public UserService(AuthorRepository authorRepository, MemberRepository memberRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {

        this.authorRepository = authorRepository;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }



    public User signup(User user) {
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }


    public Object getLoggedInUserDetails(String name) {
        User user = userRepository.getByUsername(name);

        switch (user.getRole()){
            case "AUTHOR"->{
                Author author = authorRepository.getByUsername(name);
                return author;
            }
            case "MEMBER"->{
                Member member = memberRepository.getByUsername(name);
                return member;
            }
            default -> {
                return null;
            }
        }
    }
}
