package com.fullstack.discuss_hub.feature.post.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePostRequest {
    @NotBlank
    private String content;
    private String postImageUrl;

}
