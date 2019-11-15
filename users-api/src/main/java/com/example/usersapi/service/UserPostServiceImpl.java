package com.example.usersapi.service;

import com.example.usersapi.model.Post;
import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPostServiceImpl implements UserPostService {

    @Autowired
    UserPostRepository userPostRepository;

    @Autowired
    PostService postService;

    public Post save(long userId, long postId){
        Post post = postService.searchById(postId);
        if(post != null && userPostRepository.save(userId, postId) == 1){
            return post;
        }
        return null;
    }

    public List<Post> getPostsByUser(long userId){
        List<Long> postIds = userPostRepository.getPostsByUser(userId);
        List<Post> posts = new ArrayList<>();
        postIds.forEach(id -> {
            posts.add(postService.searchById(id));
        });
        return posts;
    }
}