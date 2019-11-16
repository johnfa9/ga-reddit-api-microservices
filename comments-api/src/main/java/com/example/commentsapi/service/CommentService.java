package com.example.commentsapi.service;

import com.example.commentsapi.model.Comment;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CommentService {

    public Iterable<Comment> getAll();

    public Comment searchById(long id);

    public Iterable<Comment> searchByText(String text);

//    public List<Post> searchByLength(int min, int max);
//
//    public List<Post> searchByContent(String content);

    public HttpStatus deleteComment(long id);


    public HttpStatus createComment(Comment comment, long userId);

    List<Comment> listCommentsByUser(long userId);

    List<Comment> listCommentsByPost(long postId);

    public HttpStatus updateComment(long id, Comment CommentRequest);
}