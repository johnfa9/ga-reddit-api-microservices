package com.example.postsapi.service;

import com.example.postsapi.model.Post;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface PostService {

    public Iterable<Post> getAll();

    public Post searchById(long id);

    public Iterable<Post> searchByText(String text);

//    public List<Post> searchByLength(int min, int max);
//
//    public List<Post> searchByContent(String content);

    public HttpStatus deletePost(long id);

    public HttpStatus createPost(Post Post);

    public HttpStatus updatePost(long id, Post PostRequest);
}