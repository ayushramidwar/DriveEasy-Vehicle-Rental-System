package com.driveeasy.service;

import com.driveeasy.model.User;
import com.driveeasy.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(User user) {
        return repository.save(user);
    }

    public User login(String email, String password) {

        User user = repository.findByEmail(email);

        if(user != null &&
                user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}