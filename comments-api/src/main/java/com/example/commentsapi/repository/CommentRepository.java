package com.example.commentsapi.repository;

import com.example.commentsapi.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByTextContaining(String text);
    List<Comment> findByUserId(long userId);
    //    List<Post> findByUserId(long userId);
//    List<Post> findByLengthBetween(int min, int max);
//    List<Post> findByContentContaining(String content);
}