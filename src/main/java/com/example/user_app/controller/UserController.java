package com.example.user_app.controller;

import com.example.user_app.entity.User;
import com.example.user_app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return "{ \"id\": \"" + id + "\", \"name\": \"Pramod\", \"city\": \"Ghaziabad\" }";
    }

    @PostMapping
    public User createUser(@RequestBody User body) {
        return userService.createUser(body);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
