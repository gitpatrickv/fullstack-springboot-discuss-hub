package com.fullstack.discuss_hub.feature.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommunityInfoResponse {
    private Integer communityId;
    private String communityName;
    private String description;
}
