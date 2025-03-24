package com.fullstack.discuss_hub.feature.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePostRequest {
    private String content;
    private String postImageUrl;
}
