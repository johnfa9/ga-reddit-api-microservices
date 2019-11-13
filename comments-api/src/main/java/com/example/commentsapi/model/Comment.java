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

    @Column(name = "user_id")
    private long userId;

    @Column(name = "post_id")
    private long postId;

    public Comment() {}

    //public Post(long id, String title, int length, String content)
//    public Comment(long id, String text) {
//        this.id = id;
//        this.text=text;
//
////        this.title = title;
////        this.length = length;
////        this.content = content;
//    }

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
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