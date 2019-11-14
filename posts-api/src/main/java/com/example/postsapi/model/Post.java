package com.example.postsapi.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name = "user_id")
    private long userId;

    public Post() {}

//    //public Post(long id, String title, int length, String content)
//    public Post(long id, String title, String description) {
//        this.id = id;
//        this.title=title;
//        this.description=description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("User{")
                .append("id:").append(id)
                .append(",title:").append(title)
                .append(",description:").append(description)
//                .append(",content:").append(content)
                .append("}");
        return s.toString();
    }
}