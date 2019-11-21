CREATE TABLE comments (
    id SERIAL,
    _text VARCHAR(200),
    post_id INT,
    username VARCHAR(50),
    user_id INT
);