package com.fullstack.discuss_hub.feature.comment.service;

import com.fullstack.discuss_hub.feature.comment.dto.CommentRequest;

public interface CommentService {

    void writeComment(CommentRequest request);

}
