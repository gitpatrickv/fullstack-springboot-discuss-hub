package com.fullstack.discuss_hub.feature.comment.repository;

import com.fullstack.discuss_hub.feature.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
