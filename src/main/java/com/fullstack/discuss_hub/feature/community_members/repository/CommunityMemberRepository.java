package com.fullstack.discuss_hub.feature.community_members.repository;

import com.fullstack.discuss_hub.feature.community_members.model.CommunityMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunityMemberRepository extends JpaRepository<CommunityMember, Integer> {

    @Query("SELECT cm FROM CommunityMember cm WHERE cm.community.communityName = :name AND cm.user.userId = :userId")
    Optional<CommunityMember> findExistingMember(@Param("name") String name, @Param("userId") Integer userId);

    void deleteByUser_UserIdAndCommunity_CommunityName(Integer userId, String name);
}
