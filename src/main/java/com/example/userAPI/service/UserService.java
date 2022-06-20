package com.example.userAPI.service;
import com.example.userAPI.model.User;
import com.example.userAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Integer save(User user) {
         userRepo.save(user);
         return user.getId();
    }
}
