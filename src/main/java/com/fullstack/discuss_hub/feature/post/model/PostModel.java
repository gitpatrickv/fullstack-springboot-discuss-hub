package com.fullstack.discuss_hub.feature.post.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fullstack.discuss_hub.common.dto.Model;
import com.fullstack.discuss_hub.feature.community.model.CommunityModel;
import com.fullstack.discuss_hub.feature.post.dto.PostUserInfoResponse;
import com.fullstack.discuss_hub.feature.post.enums.PostStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
public class PostModel extends Model {
    private Integer postId;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private PostStatus status;
    private PostUserInfoResponse user;
    private CommunityModel community;
}
