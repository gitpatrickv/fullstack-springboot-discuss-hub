package com.fullstack.discuss_hub.security.controller;

import com.fullstack.discuss_hub.security.dto.request.LoginRequest;
import com.fullstack.discuss_hub.security.dto.response.LoginResponse;
import com.fullstack.discuss_hub.security.service.AuthService;
import com.fullstack.discuss_hub.feature.user.model.UserModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        log.info("Login Request: Email: {} Password: {}", loginRequest.getEmail(), loginRequest.getPassword());
        LoginResponse loginResponse = authService.login(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public  ResponseEntity<LoginResponse> registerUser(@RequestBody @Valid UserModel userModel){
        LoginResponse loginResponse = authService.registerUser(userModel);
        return new ResponseEntity<>(loginResponse, HttpStatus.CREATED);
    }
}
