package com.fullstack.discuss_hub.feature.post.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
public class PostUserInfoResponse {
    private Long userId;
    private String username;
    private String photoUrl;
}
