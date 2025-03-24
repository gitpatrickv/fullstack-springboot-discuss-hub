package com.fullstack.discuss_hub.feature.post.controller;

import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.model.Post;
import com.fullstack.discuss_hub.feature.post.model.PostModel;
import com.fullstack.discuss_hub.feature.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;
    @PostMapping
    public ResponseEntity<PostModel> createPost(@RequestBody CreatePostRequest request) {
        log.info("Received Request to create post. Post: {}", request);
        PostModel postModel = postService.createPost(request);
        log.info("Post created. Post: {}", postModel);
        return new ResponseEntity<>(postModel, HttpStatus.CREATED);
    }

}
