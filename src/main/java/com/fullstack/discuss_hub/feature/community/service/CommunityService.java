package com.fullstack.discuss_hub.feature.community.service;

import com.fullstack.discuss_hub.feature.community.dto.CreateCommunityRequest;
import com.fullstack.discuss_hub.feature.community.model.CommunityModel;

import java.util.List;

public interface CommunityService {

    CommunityModel createCommunity(CreateCommunityRequest request);
    CommunityModel joinCommunity(String name);
    List<CommunityModel> getAllCommunities();
}
