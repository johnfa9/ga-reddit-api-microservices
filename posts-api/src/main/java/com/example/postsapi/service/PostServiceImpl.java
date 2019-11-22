package com.example.postsapi.service;

import com.example.postsapi.model.Post;
import com.example.postsapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Iterable<Post> getAll() {

        return postRepository.findAll();
    }

    @Override
    public Post searchById(long id) {
 
        return postRepository.findById(id).get();
    }

    @Override
    public Iterable<Post> searchByText(String text) {

        return postRepository.findByTitleContaining(text);
    }

//    @Override
//    public List<Post> searchByLength(int min, int max) {
//
//        return postRepository.findByLengthBetween(min, max);
//    }
//
//    @Override
//    public List<Post> searchByContent(String content) {
//
//        return postRepository.findByContentContaining(content);
//    }

    @Override
    public HttpStatus deletePost(long id) {
        postRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus createPost(Post post) {
        postRepository.save(post);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updatePost(long id, Post postRequest) {
        Post post = postRepository.findById(id).get();
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
//        Post.setLength(PostRequest.getLength());
//        Post.setContent(PostRequest.getContent());
        postRepository.save(post);
        return HttpStatus.OK;
    }
}