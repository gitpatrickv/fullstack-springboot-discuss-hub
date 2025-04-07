package com.fullstack.discuss_hub.feature.post.service;

import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.dto.GetAllResponse;
import com.fullstack.discuss_hub.feature.post.model.PostModel;
import org.springframework.data.domain.Pageable;

public interface PostService {

    PostModel createPost(String communityName, CreatePostRequest request);
    GetAllResponse getAllPostFromCommunity(String communityName, Pageable pageable);
    GetAllResponse getAllPost(Pageable pageable);
    PostModel getOnePost(String postId);
}
