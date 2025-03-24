package com.fullstack.discuss_hub.feature.community.model;

import com.fullstack.discuss_hub.common.dto.AuditEntity;
import com.fullstack.discuss_hub.feature.community_members.model.CommunityMember;
import com.fullstack.discuss_hub.feature.post.model.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "community")
public class Community extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer community_id;
    private String communityName;
    private String description;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private List<CommunityMember> members = new ArrayList<>();

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

}
