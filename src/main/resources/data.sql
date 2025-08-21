-- data.sql (HSQLDB) - ids align with FK created_by

-- Users will get ids 1,2,3 in this order
INSERT INTO app_user (first_name, last_name, email)
VALUES ('Alice', 'Miller', 'alice.miller@example.com'),
       ('Bob', 'Smith', 'bob.smith@example.com'),
       ('Charlie', 'Brown', 'charlie.brown@example.com');

-- Tasks reference created_by 1..3
INSERT INTO task (title, description, due_date, priority, status, created_by)
VALUES ('Design database schema', 'Create initial ERD and SQL scripts', DATE '2025-08-30', 'high', 'open', 1),
       ('Implement login page', 'Develop frontend login UI with validation', DATE '2025-09-05', 'medium', 'in_progress',
        2),
       ('Set up CI/CD', 'Configure GitHub Actions pipeline for build and test', DATE '2025-09-10', 'high', 'open', 1),
       ('Write documentation', 'Prepare README and API usage docs', DATE '2025-09-15', 'low', 'open', 3);
