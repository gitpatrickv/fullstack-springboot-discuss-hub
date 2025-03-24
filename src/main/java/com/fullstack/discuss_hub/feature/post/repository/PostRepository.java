package com.fullstack.discuss_hub.feature.post.repository;

import com.fullstack.discuss_hub.feature.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
