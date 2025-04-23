CREATE TABLE IF NOT EXISTS users (
    `user_id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(30) UNIQUE NOT NULL,
    `email` VARCHAR(100) UNIQUE NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `gender` ENUM('MALE', 'FEMALE') NOT NULL,
    `role` ENUM('USER', 'ADMIN') NOT NULL,
    `account_non_expired` BOOLEAN NOT NULL DEFAULT TRUE,
    `account_non_locked` BOOLEAN NOT NULL DEFAULT TRUE,
    `credentials_non_expired` BOOLEAN NOT NULL DEFAULT TRUE,
    `enabled` BOOLEAN NOT NULL DEFAULT TRUE,
    `photo_url` VARCHAR(255) DEFAULT NULL,
    `created_date` TIMESTAMP
);

CREATE TABLE IF NOT EXISTS community (
    `community_id` INT AUTO_INCREMENT PRIMARY KEY,
    `community_name` VARCHAR(30) UNIQUE NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `community_photo_url` VARCHAR(255) DEFAULT NULL,
    `created_date` TIMESTAMP
);

CREATE TABLE IF NOT EXISTS posts (
     `post_id` INT AUTO_INCREMENT PRIMARY KEY,
     `user_id` INT NOT NULL,
     `community_id` INT NOT NULL,
     `title` VARCHAR(255) NOT NULL,
     `content` TEXT,
     `created_date` TIMESTAMP
);

CREATE TABLE IF NOT EXISTS community_members (
     `member_id` INT AUTO_INCREMENT PRIMARY KEY,
     `user_id` INT NOT NULL,
     `community_id` INT NOT NULL,
     `role` ENUM('MEMBER', 'ADMIN', 'MODERATOR')
);

CREATE TABLE IF NOT EXISTS comments (
     `comment_id` INT AUTO_INCREMENT PRIMARY KEY,
     `post_id` INT NOT NULL,
     `user_id` INT NOT NULL,
     `comment` TEXT
);

CREATE TABLE IF NOT EXISTS login_attempts (
     `attempt_id` INT AUTO_INCREMENT PRIMARY KEY,
     `email` VARCHAR(100) UNIQUE NOT NULL,
     `attempts` INT NOT NULL,
     `expiration_time` TIMESTAMP,
     `is_user_locked` BOOLEAN DEFAULT FALSE
);

