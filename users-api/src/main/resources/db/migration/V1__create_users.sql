CREATE TABLE users (
    id SERIAL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100),
    username VARCHAR(50)
);