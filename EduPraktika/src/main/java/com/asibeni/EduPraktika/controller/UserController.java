package com.asibeni.EduPraktika.controller;


import com.asibeni.EduPraktika.model.User;
import com.asibeni.EduPraktika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8095")
@RequestMapping("/edupraktika")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @PostMapping("/person")
    public void saveUser(@RequestBody User user) {
        userService.add(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }


}
