package com.example.usersapi.repository;

import com.example.usersapi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //public List<User> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);
    public List<User> findByUsername(String username);


    @Query("FROM User u WHERE u.email = ?1")
    public User login(String email);
}