CREATE DATABASE simpleblog;

USE simpleblog;

CREATE TABLE users (

                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100),
                       email VARCHAR(100),
                       password VARCHAR(100)
);

CREATE TABLE posts (

                       id INT PRIMARY KEY AUTO_INCREMENT,
                       title VARCHAR(255),
                       content TEXT,
                       tags VARCHAR(255),
                       user_id INT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);