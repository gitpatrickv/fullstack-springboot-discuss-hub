package com.fullstack.discuss_hub.feature.community.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCommunityRequest {
    @NotBlank
    @Pattern(regexp = "^[^\\s]+$", message = "Community name cannot contain spaces")
    private String communityName;
    @NotBlank
    private String description;
}
