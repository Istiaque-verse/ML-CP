DROP TABLE IF EXISTS users; 

CREATE TABLE users (
    name TEXT, 
    email TEXT
);

INSERT INTO users (name,email) 
VALUES 
    ('Goku','goku@dbz.com'),
    ('Vegeta','goku@dbz.com');

/*SELECT * FROM users;*/

ALTER TABLE users
ADD COLUMN age INTEGER DEFAULT 0;

UPDATE users 
SET age = 30 
WHERE name = 'Goku';

ALTER TABLE users 
ADD CONSTRAINT unique_email UNIQUE(email); 

SELECT * FROM users;