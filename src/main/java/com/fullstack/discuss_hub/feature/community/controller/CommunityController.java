package com.fullstack.discuss_hub.feature.community.controller;

import com.fullstack.discuss_hub.feature.community.dto.CreateCommunityRequest;
import com.fullstack.discuss_hub.feature.community.model.CommunityModel;
import com.fullstack.discuss_hub.feature.community.service.CommunityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CommunityModel createCommunity(@RequestBody @Valid CreateCommunityRequest request) {
        log.info("Create Community: Name - {}, Description - {}", request.getCommunityName(), request.getDescription());
        return communityService.createCommunity(request);
    }
    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CommunityModel joinCommunity(@PathVariable String name) {
        log.info("JoinCommunity: Community Name: {}", name);
        return communityService.joinCommunity(name);
    }

    @GetMapping
    public List<CommunityModel> getAllCommunities() {
        return communityService.getAllCommunities();
    }
}
