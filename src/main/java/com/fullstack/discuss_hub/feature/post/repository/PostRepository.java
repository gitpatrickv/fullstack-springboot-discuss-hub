package com.fullstack.discuss_hub.feature.post.repository;

import com.fullstack.discuss_hub.feature.post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("SELECT p FROM Post p WHERE p.community.communityName = :communityName")
    Page<Post> findPostByCommunityName(@Param("communityName") String communityName, Pageable pageable);
    Page<Post> findAll(Pageable pageable);
}
