package com.asibeni.EduPraktika.service;

import com.asibeni.EduPraktika.model.User;
import com.asibeni.EduPraktika.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Add user with encoded password
    public void add(User user) {
        // Encode the user's password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);  // Set the encoded password
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
