INSERT INTO users (username, email, password, gender, role, account_non_expired, account_non_locked, credentials_non_expired, enabled, created_date)
SELECT 'patrick', 'patrick@gmail.com', '$2a$10$v3PjyBH9NL1wqli3a4gZFOPJMjiraGkTDEO/IzTQ9jLquqI41XCaG', 'MALE', 'USER', true, true, true, true, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'patrick@gmail.com'
);

INSERT INTO users (username, email, password, gender, role, account_non_expired, account_non_locked, credentials_non_expired, enabled, created_date)
SELECT 'user', 'user@gmail.com', '$2a$10$v3PjyBH9NL1wqli3a4gZFOPJMjiraGkTDEO/IzTQ9jLquqI41XCaG', 'MALE', 'USER', true, true, true, true, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'user@gmail.com'
);

