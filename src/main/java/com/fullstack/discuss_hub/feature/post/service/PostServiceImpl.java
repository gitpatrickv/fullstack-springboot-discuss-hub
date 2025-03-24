package com.fullstack.discuss_hub.feature.post.service;

import com.fullstack.discuss_hub.common.util.mapper.EntityToModelMapper;
import com.fullstack.discuss_hub.exception.ResourceNotFoundException;
import com.fullstack.discuss_hub.feature.community.model.Community;
import com.fullstack.discuss_hub.feature.community.repository.CommunityRepository;
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
    private final CommunityRepository communityRepository;

    private EntityToModelMapper<Post, PostModel> entityToModelMapper = new EntityToModelMapper<>(PostModel.class);

    @Override
    public PostModel createPost(CreatePostRequest request) {
        return savePost(null, request);
    }

    @Override
    public PostModel createPostInCommunity(String communityName, CreatePostRequest request) {
        Community community = communityRepository.findByCommunityName(communityName)
                .orElseThrow(() -> new ResourceNotFoundException("Community not found!"));
        return savePost(community, request);
    }

    private PostModel savePost(Community community, CreatePostRequest request){
        User user = userService.getCurrentAuthenticatedUser();
        Post savedPost = Post.builder()
                .content(request.getContent())
                .postImageUrl(request.getPostImageUrl())
                .community(community)
                .user(user)
                .build();
        postRepository.save(savedPost);
        return entityToModelMapper.map(savedPost);
    }
}
