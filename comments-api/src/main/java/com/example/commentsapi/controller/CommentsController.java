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

    @PostMapping("/create")
    public HttpStatus createComment(@RequestBody Comment comment, @RequestHeader("userid") long userId) {
        return commentService.createComment(comment, userId);
    }

    @GetMapping("/view/user")
    public List<Comment> listCommentsByUser(@RequestHeader("userid") long userId) {
        return commentService.listCommentsByUser(userId);
    }

    @GetMapping("/view/post/{postId}")
    public List<Comment> listCommentsByPost(@PathVariable long postId) {
        return commentService.listCommentsByPost(postId);
    }


    @PatchMapping("/update/{id}")
    public HttpStatus updatePost(@PathVariable long id, @RequestBody Comment commentRequest) {
        return commentService.updateComment(id, commentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteComment(@PathVariable long id) {
        return commentService.deleteComment(id);
    }

//     \/ not needed in front end \/

    //    @GetMapping("view/user")
//    public List<Post> listPostByUser(@RequestHeader("userid") long userId) {
//        return postService.listPostByUser(userId);
//    }

    //    @PostMapping("/create")
//    public HttpStatus createComment(@RequestBody Comment Comment) {
//        return commentService.createComment(Comment);
//    }

    @GetMapping("/all")
    public Iterable<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/view/{id}")
    public Comment searchById(@PathVariable long id) {
        return commentService.searchById(id);
    }

}