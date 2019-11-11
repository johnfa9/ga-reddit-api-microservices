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

    @Column(name="_text")
    private String text;

    public Post() {}

    //public Post(long id, String title, int length, String content)
    public Post(long id, String text) {
        this.id = id;
        this.text=text;

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
        s.append("Post{")
                .append("id:").append(id)
                .append(",text:").append(text)
//                .append(",length:").append(length)
//                .append(",content:").append(content)
                .append("}");
        return s.toString();
    }
}