package com.example.userAPI.controller;

import com.example.userAPI.model.User;
import com.example.userAPI.repository.UserRepository;
import com.example.userAPI.validators.CheckValid;
import com.example.userAPI.validators.EmailValidator;
import com.example.userAPI.validators.PhoneValidator;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/auth/register", produces = "application/json")
    public ResponseEntity register(@RequestBody User user) {

        if (user.getPhone() != null && !user.getPhone().isBlank()) {
            if (!CheckValid.CheckValid(new PhoneValidator(), user.getPhone()))
                return new ResponseEntity("Введен некорректный номер телефона.", HttpStatus.BAD_REQUEST);
        }
        if (user.getEmail() != null && !user.getEmail().isBlank()) {
            if (!CheckValid.CheckValid(new EmailValidator(), user.getEmail()))
                return new ResponseEntity("Введена некорректная почта.", HttpStatus.BAD_REQUEST);
        }

        User local = new User(user.getName(), user.getLogin(), user.getPassword(), user.getPhone(), user.getBirthDate(), user.getTg(), user.getEmail());
        try {
            return new ResponseEntity(userRepository.reg(local), HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/auth/login", produces = "application/json")
    public ResponseEntity login(@RequestBody User user) {
        try {
            return new ResponseEntity(userRepository.login(user.getLogin(), user.getPassword()), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/auth/login/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        try {
            User user = userRepository.findById(id);
            return new ResponseEntity(user, HttpStatus.ACCEPTED);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity("Пользователь с id=" + id + " не найден.", HttpStatus.NOT_FOUND);
        }
    }
}
