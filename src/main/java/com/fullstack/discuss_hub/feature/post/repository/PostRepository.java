package com.fullstack.discuss_hub.feature.post.repository;

import com.fullstack.discuss_hub.feature.post.enums.PostStatus;
import com.fullstack.discuss_hub.feature.post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("SELECT p FROM Post p WHERE p.community.communityName = :communityName AND p.status = :status")
    Page<Post> findPostByCommunityName(@Param("communityName") String communityName, @Param("status") PostStatus status, Pageable pageable);
    Page<Post> findAllByStatus(PostStatus status, Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post p SET p.status = :status WHERE p.postId = :postId")
    void softDeletePost(@Param("postId") Integer postId, @Param("status") PostStatus status);
}
