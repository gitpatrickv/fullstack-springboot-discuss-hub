package com.fullstack.discuss_hub.feature.post.dto;

import com.fullstack.discuss_hub.common.dto.Model;
import com.fullstack.discuss_hub.common.dto.response.PageResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllResponse {
    private List<? extends Model> models;
    private PageResponse pageResponse;
}
