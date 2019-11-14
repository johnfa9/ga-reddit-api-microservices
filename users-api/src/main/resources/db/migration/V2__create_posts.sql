CREATE TABLE posts (
    id SERIAL,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(200),
    user_id INT NOT NULL
);