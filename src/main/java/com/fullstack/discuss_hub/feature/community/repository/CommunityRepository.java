package com.fullstack.discuss_hub.feature.community.repository;

import com.fullstack.discuss_hub.feature.community.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {

    Optional<Community> findByCommunityName(String name);

    @Query("SELECT cm.community FROM CommunityMember cm WHERE cm.user.userId = :userId")
    List<Community> findAllCommunitiesByUser(@Param("userId") Integer userId);
}
