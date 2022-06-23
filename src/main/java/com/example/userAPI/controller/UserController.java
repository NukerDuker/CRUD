package com.example.userAPI.controller;

import com.example.userAPI.model.User;
import com.example.userAPI.repository.UserRepository;
import com.example.userAPI.utils.JsonResponse;
import com.example.userAPI.utils.CheckValid;
import com.example.userAPI.validators.EmailValidator;
import com.example.userAPI.validators.PasswordValidator;
import com.example.userAPI.validators.PhoneValidator;
import com.example.userAPI.validators.TgValidator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class UserController {

    public Gson gson = new Gson();

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/auth/register", produces = "application/json")
    public ResponseEntity<String> register(@RequestBody User user) {

        CheckValid isValid = new CheckValid(user);

        if(!isValid.fullCheck()) {
            return new ResponseEntity<>(isValid.getJson(), HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(userRepository.reg(user), HttpStatus.CREATED);
        } catch (Exception e) {
            String json = gson.toJson(JsonResponse.getResponse("N5", e.getMessage()));
            return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/auth/login", produces = "application/json")
    public ResponseEntity login(@RequestBody User user) {
        try {
            return new ResponseEntity(userRepository.login(user.getLogin(), user.getPassword()), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            String json = gson.toJson(JsonResponse.getResponse("L3", e.getMessage()));
            return new ResponseEntity(json, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/user/{id}", produces = "application/json")
    public ResponseEntity getUser(@PathVariable int id) {
        try {
            User user = userRepository.findById(id);
            return new ResponseEntity(user, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            String json = gson.toJson(JsonResponse.getResponse("Z63", e.getMessage()));
            return new ResponseEntity(json, HttpStatus.NOT_FOUND);
        }
    }
}
