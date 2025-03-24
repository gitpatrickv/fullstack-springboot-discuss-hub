package com.fullstack.discuss_hub.feature.post.service;

import com.fullstack.discuss_hub.common.util.mapper.EntityToModelMapper;
import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.model.Post;
import com.fullstack.discuss_hub.feature.post.model.PostModel;
import com.fullstack.discuss_hub.feature.post.repository.PostRepository;
import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final UserService userService;
    private final PostRepository postRepository;

    private EntityToModelMapper<Post, PostModel> entityToModelMapper = new EntityToModelMapper<>(PostModel.class);

    @Override
    public PostModel createPost(CreatePostRequest request) {
        User user = userService.getCurrentAuthenticatedUser();
        Post savedPost = Post.builder()
                .content(request.getContent())
                .postImageUrl(request.getPostImageUrl())
                .user(user)
                .build();
        postRepository.save(savedPost);
        return entityToModelMapper.map(savedPost);
    }
}
