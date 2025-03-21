package com.fullstack.discuss_hub.security.service;

import com.fullstack.discuss_hub.security.dto.request.LoginRequest;
import com.fullstack.discuss_hub.security.dto.response.LoginResponse;
import com.fullstack.discuss_hub.feature.user.model.UserModel;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
    LoginResponse registerUser(UserModel userModel);
}
