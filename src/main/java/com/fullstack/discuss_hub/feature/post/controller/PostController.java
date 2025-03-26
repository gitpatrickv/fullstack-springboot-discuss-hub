package com.fullstack.discuss_hub.feature.post.controller;

import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.model.PostModel;
import com.fullstack.discuss_hub.feature.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fullstack.discuss_hub.common.util.PageableUtils.createPaginationAndSorting;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;
    @PostMapping
    public ResponseEntity<PostModel> createPost(@RequestParam(value = "communityName", defaultValue = "public") String communityName,
                                                @Valid @RequestBody CreatePostRequest request) {
        log.info("Received Request to create post");
        PostModel postModel = postService.createPost(communityName, request);
        log.info("Post created. Title: {} Content: {}, Community Name: {}", request.getTitle(), request.getContent(), communityName);
        return new ResponseEntity<>(postModel, HttpStatus.CREATED);
    }
    @GetMapping
    public List<PostModel> getAllPost(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                      @RequestParam(value = "sortBy", defaultValue = "createdDate") String sortBy,
                                      @RequestParam(value = "sortDirection", defaultValue = "DESC") String sortDirection,
                                      @RequestParam(value = "communityName", defaultValue = "public") String communityName) {
        Pageable pageable = createPaginationAndSorting(pageNo,pageSize,sortBy,sortDirection);
        return postService.getAllPost(communityName, pageable);
    }

}

