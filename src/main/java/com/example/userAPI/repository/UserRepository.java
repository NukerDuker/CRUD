package com.example.userAPI.repository;


import com.example.userAPI.model.User;

public interface UserRepository {
    User reg(User user);
    User login(String login, String password);
    User findById(int id);
    Integer getUserId(User user);
}
