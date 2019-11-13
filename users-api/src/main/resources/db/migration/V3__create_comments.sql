CREATE TABLE comments (
    id SERIAL,
    text VARCHAR(200),
    post_id INT,
    user_id INT
);