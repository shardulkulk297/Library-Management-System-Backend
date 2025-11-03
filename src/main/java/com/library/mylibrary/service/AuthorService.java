package com.library.mylibrary.service;

import com.library.mylibrary.model.Author;
import com.library.mylibrary.model.User;
import com.library.mylibrary.repository.AuthorRepository;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorRepository authorRepository;
    public Author addAuthor(Author author) {
        User user = author.getUser();
        user = userService.signup(user);
        author.setUser(user);
        return authorRepository.save(author);
    }
}
