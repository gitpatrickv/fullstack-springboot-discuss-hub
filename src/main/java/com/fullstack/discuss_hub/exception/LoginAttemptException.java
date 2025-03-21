package com.fullstack.discuss_hub.exception;

public class LoginAttemptException extends RuntimeException{
    public LoginAttemptException(int expirationTime) {
        super(String.format("Too many failed login attempts. Please try again in %s minutes", expirationTime));
    }
}
