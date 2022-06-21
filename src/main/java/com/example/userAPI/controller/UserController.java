package com.example.userAPI.controller;

import com.example.userAPI.model.User;
import com.example.userAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth/register")
    public ResponseEntity register(@RequestBody User user) {
        User local = new User(user.getName(), user.getLogin(), user.getPassword(), user.getPhone(), user.getBirthDate(), user.getTg(), user.getEmail());
        try {
            local = userRepository.reg(local);
            return new ResponseEntity(local, HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity("Логин уже существует.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity login(@RequestBody User user) {
        try{
            User local = userRepository.login(user.getLogin(), user.getPassword());
            return new ResponseEntity(local, HttpStatus.ACCEPTED);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/auth/login/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        try{
            User user = userRepository.findById(id);
            return new ResponseEntity(user, HttpStatus.ACCEPTED);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("Пользователь с id=" + id + " не найден.", HttpStatus.NOT_FOUND);
        }
    }
}
