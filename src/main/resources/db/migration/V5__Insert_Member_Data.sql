INSERT INTO community_members (user_id, community_id, role)
SELECT 1, 1, 'ADMIN'
WHERE NOT EXISTS (
    SELECT 1 FROM community_members WHERE user_id = 1 AND community_id = 1
);