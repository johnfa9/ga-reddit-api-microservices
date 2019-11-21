package com.example.usersapi.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "user_name")
//    private String userName;
    @Column(name = "_email")
    private String email;
//    @Column(name = "first_name")
//    private String firstName;
    @Column(name = "_password")
    private String password;

//    @Column(name = "last_name")
//    private String lastName;
    @Column(name = "user_name")
    private String username;

    public User() {}

    //public User(long id, String userName, String firstName, String lastName)
    public User(long id, String email, String password, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("User{")
                .append("id:").append(id)
                .append(",email:").append(email)
                .append(",password:").append(password)
                .append(",username:").append(username)
                .append("}");
        return s.toString();
    }
}