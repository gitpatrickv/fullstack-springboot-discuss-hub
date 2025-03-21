package com.fullstack.discuss_hub.feature.user.controller;

import com.fullstack.discuss_hub.feature.user.model.UserModel;
import com.fullstack.discuss_hub.feature.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserModel> getCurrentUserInfo() {
        log.info("fetching current user info");
        return ResponseEntity.ok(userService.getCurrentUserInfo());
    }
    @GetMapping("/string")
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("String coming from backend");
    }

}
