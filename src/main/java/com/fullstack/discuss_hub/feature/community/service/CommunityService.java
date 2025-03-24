package com.fullstack.discuss_hub.feature.community.service;

import com.fullstack.discuss_hub.feature.community.dto.CreateCommunityRequest;

public interface CommunityService {

    void createCommunity(CreateCommunityRequest request);
}
