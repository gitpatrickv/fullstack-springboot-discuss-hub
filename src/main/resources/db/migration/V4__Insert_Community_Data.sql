INSERT INTO community (community_name, description, created_date)
SELECT 'public', 'A place to discuss random things', CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM community WHERE community_name = 'public'
);