CREATE TABLE comments (
    id SERIAL,
    text VARCHAR(200),
    post_id INT NOT NULL,
    user_id INT NOT NULL
);