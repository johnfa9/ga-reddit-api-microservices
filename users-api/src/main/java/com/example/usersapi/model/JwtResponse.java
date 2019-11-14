package com.example.usersapi.model;

public class JwtResponse {

    private String jwt;

    private String username;

    public JwtResponse(String jwt, String username) {
        this.jwt = jwt;
        this.username = username;
    }

    public String getToken() {
        return this.jwt;
    }

    public String getUsername() {
        return username;
    }
}