package com.fullstack.discuss_hub.feature.post.controller;

import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.dto.GetAllResponse;
import com.fullstack.discuss_hub.feature.post.model.PostModel;
import com.fullstack.discuss_hub.feature.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.OK)
    public GetAllResponse getAllPost(@RequestParam(value = "communityName") String communityName,
                                     @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                     @RequestParam(value = "sortBy", defaultValue = "createdDate") String sortBy,
                                     @RequestParam(value = "sortDirection", defaultValue = "DESC") String sortDirection) {
        Pageable pageable = createPaginationAndSorting(pageNo,pageSize,sortBy,sortDirection);
        log.info("GetAllPost - Community Name: {}, SortBy: {}, SortDir: {}", communityName, sortBy, sortDirection);
        return communityName.equals("HOME") ? postService.getAllPost(pageable) : postService.getAllPostFromCommunity(communityName, pageable);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostModel> getOnePost(@PathVariable String postId){
        log.info("Received the request to get the post with Post Id - {}.", postId);
        PostModel postModel = postService.getOnePost(postId);
        log.info("GetOnePost: PostId: {} was retrieved successfully", postId);
        return ResponseEntity.ok(postModel);
    }

}


