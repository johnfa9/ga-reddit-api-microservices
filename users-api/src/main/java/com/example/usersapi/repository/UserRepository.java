package com.example.usersapi.repository;

import com.example.usersapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //public List<User> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);
    public List<User> findByUsername(String username);
}