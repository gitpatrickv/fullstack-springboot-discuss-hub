package com.fullstack.discuss_hub.feature.post.service;

import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.model.PostModel;

public interface PostService {

    PostModel createPost(CreatePostRequest request);

}
