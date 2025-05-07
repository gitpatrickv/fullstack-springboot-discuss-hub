package com.fullstack.discuss_hub.feature.vote.model;

import com.fullstack.discuss_hub.feature.post.model.Post;
import com.fullstack.discuss_hub.feature.user.model.User;
import com.fullstack.discuss_hub.feature.vote.enums.VoteType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer voteId;

    @Enumerated(EnumType.STRING)
    private VoteType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
