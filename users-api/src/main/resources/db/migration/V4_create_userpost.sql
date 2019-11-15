CREATE TABLE user_post (
    user_id INT REFERENCES users(id),
    post_id INT REFERENCES posts(id),
    PRIMARY KEY (user_id, post_id)
);