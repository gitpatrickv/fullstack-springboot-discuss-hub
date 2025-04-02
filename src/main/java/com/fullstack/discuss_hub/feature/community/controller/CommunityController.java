package com.fullstack.discuss_hub.feature.community.controller;

import com.fullstack.discuss_hub.feature.community.dto.CreateCommunityRequest;
import com.fullstack.discuss_hub.feature.community.service.CommunityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createCommunity(@RequestBody @Valid CreateCommunityRequest request) {
        log.info("Create Community: Name - {}, Description - {}", request.getCommunityName(), request.getDescription());
        communityService.createCommunity(request);
    }
}
