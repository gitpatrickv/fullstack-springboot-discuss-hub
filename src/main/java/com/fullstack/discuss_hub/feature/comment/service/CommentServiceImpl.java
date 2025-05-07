package com.fullstack.discuss_hub.feature.comment.service;

import com.fullstack.discuss_hub.exception.ResourceNotFoundException;
import com.fullstack.discuss_hub.feature.comment.dto.CommentRequest;
import com.fullstack.discuss_hub.feature.comment.model.Comment;
import com.fullstack.discuss_hub.feature.comment.repository.CommentRepository;
import com.fullstack.discuss_hub.feature.post.model.Post;
import com.fullstack.discuss_hub.feature.post.service.PostService;
import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;
    @Override
    public void writeComment(CommentRequest request) {
        Comment parent = null;

        if(request.getParentCommentId() != null){
            parent = commentRepository.findById(request.getParentCommentId())
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found!"));
        }

        this.saveComment(request, parent);
    }

    private void saveComment(CommentRequest request, Comment parent){
        Post post = postService.getPostById(request.getPostId());
        User user = userService.getCurrentAuthenticatedUser();
        Comment comment = Comment.builder()
                .comment(request.getComment())
                .parentComment(parent)
                .user(user)
                .post(post)
                .build();
        commentRepository.save(comment);
    }
}

