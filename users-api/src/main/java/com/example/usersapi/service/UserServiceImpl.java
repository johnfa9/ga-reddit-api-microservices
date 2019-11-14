package com.example.usersapi.service;

import com.example.usersapi.config.JwtUtil;
import com.example.usersapi.model.JwtResponse;
import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Iterable<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public User searchById(long id) {

        return userRepository.findById(id).get();
    }


    @Override
    public HttpStatus deleteUser(long id) {
        userRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public JwtResponse createUser(User user) {
        user.setPassword(encoder().encode(user.getPassword()));
        if(userRepository.save(user) != null){
            return new JwtResponse(jwtUtil.generateToken(String.valueOf(user.getId())), user.getUsername()) ;
        }

        return null;
    }


    @Override
    public JwtResponse login(User user) {
        User foundUser = userRepository.login(user.getEmail());
        if (foundUser != null && encoder().matches(user.getPassword(), foundUser.getPassword())) {
            String token = jwtUtil.generateToken(foundUser.getUsername());
            return new JwtResponse(token, foundUser.getUsername());
        }
        return null;
    }

//    @Override
//    public Iterable<User> searchByName(String name) {
//        String normalized = name.trim().toLowerCase();
//        //return userRepository.findByFirstNameContainsOrLastNameContains(normalized, normalized);
//        return userRepository.findByUsername(normalized);
//    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
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