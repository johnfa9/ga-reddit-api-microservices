package com.example.postsapi.controller;

import com.example.postsapi.model.Post;
import com.example.postsapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostsController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public Iterable<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/view/{id}")
    public Post searchById(@PathVariable long id) {
        return postService.searchById(id);
    }

//    @GetMapping("/searchTitle/{title}")
//    public Iterable<Post> searchByTitle(@PathVariable String title) {
//        return postService.searchByTitle(title);
//    }
//
//    @GetMapping("/searchLength")
//    public List<Post> searchByLength(@RequestParam int min, @RequestParam int max) {
//        return postService.searchByLength(min, max);
//    }
//
//    @GetMapping("/searchContent/{content}")
//    public List<Post> searchByContent(@PathVariable String content) {
//        return postService.searchByContent(content);
//    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deletePost(@PathVariable long id) {
        return postService.deletePost(id);
    }

    @PostMapping("/create")
    public HttpStatus createPost(@RequestBody Post Post) {
        return postService.createPost(Post);
    }

    @PatchMapping("/update/{id}")
    public HttpStatus updatePost(@PathVariable long id, @RequestBody Post postRequest) {
        return postService.updatePost(id, postRequest);
    }
}