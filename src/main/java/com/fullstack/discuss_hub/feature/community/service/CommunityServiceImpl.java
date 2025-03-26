package com.fullstack.discuss_hub.feature.community.service;

import com.fullstack.discuss_hub.feature.community.dto.CreateCommunityRequest;
import com.fullstack.discuss_hub.feature.community.model.Community;
import com.fullstack.discuss_hub.feature.community.repository.CommunityRepository;
import com.fullstack.discuss_hub.feature.community_members.enums.CommunityRole;
import com.fullstack.discuss_hub.feature.community_members.model.CommunityMember;
import com.fullstack.discuss_hub.feature.community_members.repository.CommunityMemberRepository;
import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;
    private final UserService userService;
    private final CommunityMemberRepository communityMemberRepository;
    @Transactional
    @Override   //TODO: Not yet implemented in Angular
    public void createCommunity(CreateCommunityRequest request) {

        User user = userService.getCurrentAuthenticatedUser();

        Community community = Community.builder()
                .communityName(request.getCommunityName())
                .description(request.getDescription())
                .members(new ArrayList<>())
                .build();
        communityRepository.save(community);

        CommunityMember communityMember = CommunityMember.builder()
                .role(CommunityRole.ADMIN)
                .user(user)
                .community(community)
                .build();
        communityMemberRepository.save(communityMember);

        community.getMembers().add(communityMember);

    }


}
