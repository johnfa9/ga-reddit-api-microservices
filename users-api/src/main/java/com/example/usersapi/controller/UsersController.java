package com.example.usersapi.controller;


import com.example.usersapi.model.JwtResponse;
import com.example.usersapi.model.User;
import com.example.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/view/{id}")
    public User searchById(@PathVariable long id) {
        return userService.searchById(id);
    }

    @GetMapping("/search/{name}")
    public User searchByName(@PathVariable String name) {
        return userService.getUserByUsername(name);
    }  //works with firstname

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteUser(@PathVariable long id) {

        return userService.deleteUser(id);
    }

    @PostMapping("/create")
    public JwtResponse createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    //testing error

    @PostMapping("/login")
    public JwtResponse login(@RequestBody User user) {
        return userService.login(user);
    }

    @PatchMapping("/update/{id}")
    public HttpStatus updateUser(@PathVariable long id, @RequestBody User userRequest) {
        return userService.updateUser(id, userRequest);
    }
    //testing ok
}