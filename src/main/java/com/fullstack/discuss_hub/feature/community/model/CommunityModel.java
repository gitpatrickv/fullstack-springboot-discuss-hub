package com.fullstack.discuss_hub.feature.community.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommunityModel {
    private Integer communityId;
    private String communityName;
    private String description;
    private String communityPhotoUrl;
}
