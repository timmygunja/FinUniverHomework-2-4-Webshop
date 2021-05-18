package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) { userRepository.delete(user);}

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User find(Long id) {
        return userRepository.findById(id).get();
    }
}
