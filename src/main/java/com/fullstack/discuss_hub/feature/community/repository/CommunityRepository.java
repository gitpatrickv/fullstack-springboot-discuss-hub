package com.fullstack.discuss_hub.feature.community.repository;

import com.fullstack.discuss_hub.feature.community.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {

    Optional<Community> findByCommunityName(String name);
}
