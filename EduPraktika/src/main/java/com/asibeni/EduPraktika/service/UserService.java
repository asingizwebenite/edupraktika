package com.asibeni.EduPraktika.service;

import com.asibeni.EduPraktika.model.User;
import com.asibeni.EduPraktika.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void add(User user) {
        userRepository.save(user);
    }
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public void delete(User user) {
        userRepository.delete(user);
    }
    public User getUserById(int id) {
        return userRepository.getById(id);
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }



}
