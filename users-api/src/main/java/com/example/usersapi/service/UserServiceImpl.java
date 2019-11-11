package com.example.usersapi.service;

import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public User searchById(long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public Iterable<User> searchByName(String name) {
        String normalized = name.trim().toLowerCase();
        //return userRepository.findByFirstNameContainsOrLastNameContains(normalized, normalized);
        return userRepository.findByUsername(normalized);
    }

    @Override
    public HttpStatus deleteUser(long id) {
        userRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus createUser(User user) {
        userRepository.save(user);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateUser(long id, User userRequest) {
        User user = userRepository.findById(id).get();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setUsername(userRequest.getUsername());
        userRepository.save(user);
        return HttpStatus.OK;
    }
}