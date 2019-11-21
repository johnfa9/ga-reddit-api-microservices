package com.example.postsapi.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


//    @Column(name = "duration")
//    private int length;
//    private String content;

    @Column(name="_title")
    private String title;

    @Column(name="_description")
    private String description;

    @Column(name="user_id")
    private String user_id;

    public Post() {}

    //public Post(long id, String title, int length, String content)
    public Post(long id, String title, String description) {
        this.id = id;
        this.title=title;
        this.description=description;

//        this.title = title;
//        this.length = length;
//        this.content = content;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getLength() {
//        return length;
//    }
//
//    public void setLength(int length) {
//        this.length = length;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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