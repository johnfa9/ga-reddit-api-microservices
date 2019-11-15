package com.example.usersapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserPostRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(long userId, long postId) {
        return jdbcTemplate.update(
                "insert into user_post (user_id, post_id) " +
                        "values(?,?)", userId, postId);
    }

    public List<Long> getPostsByUser(long userId){
        List<Long> postIds = new ArrayList<>();
        jdbcTemplate.query("select post_id from user_post where " +
                        "user_id = ?", new Object[]{userId},
                (rs, num) -> postIds.add(rs.getLong("post_id")));
        return postIds;
    }

}
