CREATE TABLE users (
    id SERIAL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR,
    username VARCHAR(50) UNIQUE NOT NULL
);