package com.example.usersapi.repository;


import com.example.usersapi.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByTitleContaining(String text);
//    List<Post> findByLengthBetween(int min, int max);
//    List<Post> findByContentContaining(String content);
}