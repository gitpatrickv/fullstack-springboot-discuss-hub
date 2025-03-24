package com.fullstack.discuss_hub.feature.community.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCommunityRequest {
    private String communityName;
    private String description;
}
