package com.fullstack.discuss_hub.feature.community_members.repository;

import com.fullstack.discuss_hub.feature.community_members.model.CommunityMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityMemberRepository extends JpaRepository<CommunityMember, Integer> {
}
