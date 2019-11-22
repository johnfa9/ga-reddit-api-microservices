package com.example.commentsapi.controller;

import com.example.commentsapi.model.Comment;
import com.example.commentsapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public Iterable<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/view/{id}")
    public Comment searchById(@PathVariable long id) {
        return commentService.searchById(id);
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
    public HttpStatus deleteComment(@PathVariable long id) {

        return commentService.deleteComment(id);
    }

    @PostMapping("/create")
    public HttpStatus createComment(@RequestHeader("userid") int userId, @RequestBody Comment comment) {
        System.out.println(userId);
        comment.setUserId(userId);
        return commentService.createComment(comment);
    }

    @PatchMapping("/update/{id}")
    public HttpStatus updatePost(@PathVariable long id, @RequestBody Comment commentRequest) {
        return commentService.updateComment(id, commentRequest);
    }
}