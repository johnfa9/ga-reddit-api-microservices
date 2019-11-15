package com.example.usersapi.service;


import com.example.usersapi.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserPostService {
    List<Post> getPostsByUser(long userId);
    Post save(long userId, long postId);
}