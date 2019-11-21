package com.example.usersapi.service;

import com.example.usersapi.model.JwtResponse;
import com.example.usersapi.model.User;
import org.springframework.http.HttpStatus;

public interface UserService {

    public Iterable<User> getAll();

    public User searchById(long id);

    public JwtResponse login(User user);

    public Iterable<User> searchByName(String name);

    public HttpStatus deleteUser(long id);

    public JwtResponse createUser(User user);

    public HttpStatus updateUser(long id, User userRequest);
}