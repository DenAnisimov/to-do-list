package com.example.todolist.service;

import com.example.todolist.entity.User;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthentificationService {
    private final UserRepository userRepository;

    @Autowired
    public AuthentificationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean signIn(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);

        return user.isPresent();
    }
}
