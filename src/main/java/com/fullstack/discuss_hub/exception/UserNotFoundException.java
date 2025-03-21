package com.fullstack.discuss_hub.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("Username not found.");
    }
}
