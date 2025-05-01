package com.fullstack.discuss_hub.feature.post.model;

import com.fullstack.discuss_hub.common.dto.AuditEntity;
import com.fullstack.discuss_hub.feature.comment.model.Comment;
import com.fullstack.discuss_hub.feature.community.model.Community;
import com.fullstack.discuss_hub.feature.post.enums.PostStatus;
import com.fullstack.discuss_hub.feature.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "posts")
public class Post extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;
}
