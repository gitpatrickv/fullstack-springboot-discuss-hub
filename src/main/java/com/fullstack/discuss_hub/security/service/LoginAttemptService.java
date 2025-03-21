package com.fullstack.discuss_hub.security.service;

public interface LoginAttemptService {

    void handleLoginAttempt(String email);
    void resetAttempt(String email);
}
