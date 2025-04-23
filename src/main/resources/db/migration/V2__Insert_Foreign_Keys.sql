ALTER TABLE posts
ADD CONSTRAINT fk_posts_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
ADD CONSTRAINT fk_posts_community_id FOREIGN KEY (community_id) REFERENCES community(community_id);

ALTER TABLE community_members
ADD CONSTRAINT fk_member_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
ADD CONSTRAINT fk_member_community_id FOREIGN KEY (community_id) REFERENCES community(community_id);

ALTER TABLE comments
ADD CONSTRAINT fk_comment_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
ADD CONSTRAINT fk_comment_post_id FOREIGN KEY (post_id) REFERENCES posts(post_id);
