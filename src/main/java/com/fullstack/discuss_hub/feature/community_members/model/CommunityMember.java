package com.fullstack.discuss_hub.feature.community_members.model;

import com.fullstack.discuss_hub.feature.community.model.Community;
import com.fullstack.discuss_hub.feature.community_members.enums.CommunityRole;
import com.fullstack.discuss_hub.feature.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "community_members")
public class CommunityMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;
    private CommunityRole role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id")
    private Community community;

    public CommunityMember(CommunityRole role, User user, Community community) {
        this.role = role;
        this.user = user;
        this.community = community;
    }
}
