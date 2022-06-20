package com.example.userAPI.controller;

import com.example.userAPI.model.User;
import com.example.userAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/register")
    public ResponseEntity<Integer> register(@RequestParam String phone, @RequestParam String login, @RequestParam String password, @RequestParam String name, @RequestParam String birth, @RequestParam(required = false) String tg, @RequestParam(required = false) String email) {
        User user = new User(name, login, password, birth, phone, tg, email);
        try {
            userService.save(user);
            return new ResponseEntity<>(user.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
