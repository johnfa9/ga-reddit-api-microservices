package com.example.commentsapi.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="text")
    private String text;

    @Column(name="post_id")
    private int postId;

    @Column(name="username")
    private String username;

    @Column(name="user_id")
    private int userId;

    public Comment() {}

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Comment{")
                .append("id:").append(id)
                .append(",text:").append(text)
//                .append(",length:").append(length)
//                .append(",content:").append(content)
                .append("}");
        return s.toString();
    }
}