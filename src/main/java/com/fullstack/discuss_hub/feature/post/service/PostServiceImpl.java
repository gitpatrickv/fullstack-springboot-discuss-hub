package com.fullstack.discuss_hub.feature.post.service;

import com.fullstack.discuss_hub.common.dto.response.PageResponse;
import com.fullstack.discuss_hub.common.util.Pagination;
import com.fullstack.discuss_hub.common.util.mapper.EntityToModelMapper;
import com.fullstack.discuss_hub.exception.ResourceNotFoundException;
import com.fullstack.discuss_hub.feature.community.model.Community;
import com.fullstack.discuss_hub.feature.community.repository.CommunityRepository;
import com.fullstack.discuss_hub.feature.post.dto.CreatePostRequest;
import com.fullstack.discuss_hub.feature.post.dto.GetAllResponse;
import com.fullstack.discuss_hub.feature.post.enums.PostStatus;
import com.fullstack.discuss_hub.feature.post.model.Post;
import com.fullstack.discuss_hub.feature.post.model.PostModel;
import com.fullstack.discuss_hub.feature.post.repository.PostRepository;
import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    public static final String POST_CACHE= "posts";

    private final UserService userService;
    private final PostRepository postRepository;
    private final CommunityRepository communityRepository;
    private final Pagination pagination;

    private EntityToModelMapper<Post, PostModel> entityToModelMapper = new EntityToModelMapper<>(PostModel.class);

    @Override
    @CachePut(value = POST_CACHE, key = "#result.postId")
    public PostModel createPost(String communityName, CreatePostRequest request) {
        User user = userService.getCurrentAuthenticatedUser();
        Community community = communityRepository.findByCommunityName(communityName)
                .orElseThrow(() -> new ResourceNotFoundException("Community not found!"));
        Post savedPost = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .status(PostStatus.ACTIVE)
                .community(community)
                .user(user)
                .build();
        postRepository.save(savedPost);
        return entityToModelMapper.map(savedPost);
    }

    @Override
    public GetAllResponse getAllPostFromCommunity(String communityName, Pageable pageable) {
        Page<Post> posts = postRepository.findPostByCommunityName(communityName, PostStatus.ACTIVE, pageable);
        return this.getResponse(posts);
    }

    @Override
    public GetAllResponse getAllPost(Pageable pageable) {
        Page<Post> posts = postRepository.findAllByStatus(PostStatus.ACTIVE, pageable);
        return this.getResponse(posts);
    }

    @Override
    @Cacheable(value = POST_CACHE, key = "#postId")
    public PostModel getOnePost(String postId) {
        return postRepository.findById(Integer.parseInt(postId))
                .map(entityToModelMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Post Id %s not found!", postId)));
    }

    @Override
    @CacheEvict(value = POST_CACHE, key = "#postId")    //TODO: not yet implemented in the frontend
    public void deletePost(Integer postId) {
        postRepository.softDeletePost(postId, PostStatus.DELETED);
    }

    @Override
    public Post getPostById(String postId) {
        return postRepository.findById(Integer.parseInt(postId))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Post Id %s not found!", postId)));
    }

    private GetAllResponse getResponse(Page<Post> post){
        List<PostModel> models = this.getAll(post);
        PageResponse pageResponse = pagination.getPagination(post);
        return new GetAllResponse(models, pageResponse);
    }

    private List<PostModel> getAll(Page<Post> post){
        return post.map(entityToModelMapper::map)
                .getContent();
    }


}
