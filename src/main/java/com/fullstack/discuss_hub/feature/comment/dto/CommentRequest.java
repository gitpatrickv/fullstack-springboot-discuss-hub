package com.fullstack.discuss_hub.feature.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequest {
    @NotBlank
    private String postId;
    @NotBlank
    private String comment;

    private Integer parentCommentId;
}
