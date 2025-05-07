package com.fullstack.discuss_hub.feature.comment.controller;

import com.fullstack.discuss_hub.feature.comment.dto.CommentRequest;
import com.fullstack.discuss_hub.feature.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void writeComment(@RequestBody @Valid CommentRequest request) {
        log.info("{} - PostId: {}, Comment: {}, ParentCommentId: {}",
                request.getParentCommentId() == null ? "WriteComment" : "ReplyToComment",
                request.getPostId(),
                request.getComment(),
                request.getParentCommentId());
        commentService.writeComment(request);
        log.info("Commented successfully on postId: {}", request.getPostId());
    }
}
