package com.library.mylibrary.controller;

import com.library.mylibrary.model.User;
import com.library.mylibrary.service.UserService;
import com.library.mylibrary.utility.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/api/user/signup")
    public ResponseEntity<?> signup(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signup(user));
    }

    @GetMapping("/api/user/getToken")
    public ResponseEntity<?> getToken(Principal principal) {
        JwtUtil jwtUtil = new JwtUtil();
        try {
            String token = jwtUtil.createToken(principal.getName());
            Map<String, String> map = new HashMap<>();
            map.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }

    @GetMapping("/api/user/getLoggedInUserDetails")
    public Object getLoggedInUser(Principal principal){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getLoggedInUserDetails(principal.getName()));
    }
}