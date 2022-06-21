package com.example.userAPI.repository;


import com.example.userAPI.model.User;

public interface UserRepository {
    String reg(User user);
    String login(String login, String password);
    User findById(int id);
    Integer getUserId(User user);
}
