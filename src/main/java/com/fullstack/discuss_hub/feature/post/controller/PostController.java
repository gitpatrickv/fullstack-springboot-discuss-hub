package com.fullstack.discuss_hub.feature.post.controller;

import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.model.PostModel;
import com.fullstack.discuss_hub.feature.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;
    @PostMapping
    public ResponseEntity<PostModel> createPost(@RequestParam(value = "communityName", required = false) String communityName,
                                                @Valid @RequestBody CreatePostRequest request) {
        log.info("Received Request to create post");

        PostModel postModel = communityName != null
                ? postService.createPostInCommunity(communityName, request)
                : postService.createPost(request);

        log.info("Post created. Content: {}, Community Name: {}", postModel.getContent(), communityName);

        return new ResponseEntity<>(postModel, HttpStatus.CREATED);
    }

}

