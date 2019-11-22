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

    @Column(name="user_id")
    private int userId;

    public Post() {}

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

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Post{")
                .append("id:").append(id)
                .append(",title:").append(title)
                .append(",description:").append(description)
//                .append(",content:").append(content)
                .append("}");
        return s.toString();
    }
}