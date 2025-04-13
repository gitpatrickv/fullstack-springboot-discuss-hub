package com.fullstack.discuss_hub.feature.community.service;

import com.fullstack.discuss_hub.common.util.mapper.EntityToModelMapper;
import com.fullstack.discuss_hub.feature.community.dto.CreateCommunityRequest;
import com.fullstack.discuss_hub.feature.community.model.Community;
import com.fullstack.discuss_hub.feature.community.model.CommunityModel;
import com.fullstack.discuss_hub.feature.community.repository.CommunityRepository;
import com.fullstack.discuss_hub.feature.community_members.enums.CommunityRole;
import com.fullstack.discuss_hub.feature.community_members.model.CommunityMember;
import com.fullstack.discuss_hub.feature.community_members.repository.CommunityMemberRepository;
import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;
    private final UserService userService;
    private final CommunityMemberRepository communityMemberRepository;

    private EntityToModelMapper<Community, CommunityModel> entityToModelMapper = new EntityToModelMapper<>(CommunityModel.class);

    @Override
    public CommunityModel createCommunity(CreateCommunityRequest request) {
        Community community = Community.builder()
                .communityName(request.getCommunityName())
                .description(request.getDescription())
                .build();
        communityRepository.save(community);
        this.communityMemberBuilder(community, CommunityRole.ADMIN);
        return this.entityToModelMapper.map(community);
    }

    @Override
    public CommunityModel joinCommunity(String name) {
        int userId = userService.getCurrentUserId();
        Optional<CommunityMember> existingMember = communityMemberRepository.findExistingMember(name, userId);

        if(existingMember.isPresent()){
            communityMemberRepository.deleteByUser_UserIdAndCommunity_CommunityName(userId, name);
        } else {
            Optional<Community> community = communityRepository.findByCommunityName(name);
            community.ifPresent(com -> this.communityMemberBuilder(com, CommunityRole.MEMBER));
            return this.entityToModelMapper.map(community.get());
        }

        throw new IllegalArgumentException("Invalid Community");
    }

    @Override
    public List<CommunityModel> getAllCommunities() {
        return communityRepository.findAllCommunitiesByUser(userService.getCurrentUserId())
                .stream()
                .map(entityToModelMapper::map)
                .toList();
    }

    private void communityMemberBuilder(Community community, CommunityRole role){
        User user = userService.getCurrentAuthenticatedUser();
        CommunityMember communityMember = CommunityMember.builder()
                .role(role)
                .user(user)
                .community(community)
                .build();
        communityMemberRepository.save(communityMember);
    }
}
