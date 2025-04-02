package com.fullstack.discuss_hub.feature.community.model;

import com.fullstack.discuss_hub.common.dto.AuditEntity;
import com.fullstack.discuss_hub.feature.community_members.model.CommunityMember;
import com.fullstack.discuss_hub.feature.post.model.Post;
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
@Table(name = "community")
public class Community extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer communityId;
    private String communityName;
    private String description;
    private String communityPhotoUrl;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private List<CommunityMember> members;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

}
