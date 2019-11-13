CREATE TABLE users (
    id SERIAL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50),
    username VARCHAR(50)
);