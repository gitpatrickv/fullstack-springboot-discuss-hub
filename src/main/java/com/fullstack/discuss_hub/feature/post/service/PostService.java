package com.fullstack.discuss_hub.feature.post.service;

import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.model.PostModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    PostModel createPost(String communityName, CreatePostRequest request);
    List<PostModel> getAllPost(String communityName, Pageable pageable);

}
