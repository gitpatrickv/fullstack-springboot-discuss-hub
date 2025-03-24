package com.fullstack.discuss_hub.feature.community_members.model;

import com.fullstack.discuss_hub.feature.community.model.Community;
import com.fullstack.discuss_hub.feature.community_members.enums.CommunityRole;
import com.fullstack.discuss_hub.feature.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "community_members")
public class CommunityMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;
    private CommunityRole role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

}
