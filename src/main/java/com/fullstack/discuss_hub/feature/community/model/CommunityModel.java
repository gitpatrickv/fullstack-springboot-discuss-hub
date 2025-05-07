package com.fullstack.discuss_hub.feature.community.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fullstack.discuss_hub.common.dto.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
public class CommunityModel extends Model {
    private Integer communityId;
    private String communityName;
    private String description;
    private String communityPhotoUrl;
}
