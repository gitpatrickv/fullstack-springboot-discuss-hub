package com.fullstack.discuss_hub.feature.community.model;

import com.fullstack.discuss_hub.common.dto.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommunityModel extends Model {
    private Integer communityId;
    private String communityName;
    private String description;
    private String communityPhotoUrl;
}
