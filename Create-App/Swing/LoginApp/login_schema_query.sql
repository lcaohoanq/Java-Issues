SELECT * FROM login_schema.users;

INSERT INTO login_schema.users (name, email, date_of_birth, password, created_at, updated_at, email_verify_token, forgot_password_token, verify, bio, location, website, username, avatar, cover_photo) 
VALUES 
('John Doe', 'john@example.com', '1990-01-01', 'hashed_password', '2024-02-28 10:00:00', '2024-02-28 10:00:00', 'email_verify_token_1', 'forgot_password_token_1', 'verified', 'Bio for John Doe', 'New York', 'http://www.example.com', 'john_doe', 'http://www.example.com/avatar1.jpg', 'http://www.example.com/cover1.jpg'),
('Jane Smith', 'jane@example.com', '1995-05-15', 'hashed_password', '2024-02-28 11:00:00', '2024-02-28 11:00:00', 'email_verify_token_2', 'forgot_password_token_2', 'unverified', 'Bio for Jane Smith', 'Los Angeles', 'http://www.example.com', 'jane_smith', 'http://www.example.com/avatar2.jpg', 'http://www.example.com/cover2.jpg'),
('Alice Johnson', 'alice@example.com', '1988-09-20', 'hashed_password', '2024-02-28 12:00:00', '2024-02-28 12:00:00', 'email_verify_token_3', 'forgot_password_token_3', 'verified', 'Bio for Alice Johnson', 'Chicago', 'http://www.example.com', 'alice_johnson', 'http://www.example.com/avatar3.jpg', 'http://www.example.com/cover3.jpg'),
('Bob Brown', 'bob@example.com', '1980-03-10', 'hashed_password', '2024-02-28 13:00:00', '2024-02-28 13:00:00', 'email_verify_token_4', 'forgot_password_token_4', 'unverified', 'Bio for Bob Brown', 'Houston', 'http://www.example.com', 'bob_brown', 'http://www.example.com/avatar4.jpg', 'http://www.example.com/cover4.jpg'),
('Emily Davis', 'emily@example.com', '1998-07-25', 'hashed_password', '2024-02-28 14:00:00', '2024-02-28 14:00:00', 'email_verify_token_5', 'forgot_password_token_5', 'verified', 'Bio for Emily Davis', 'Miami', 'http://www.example.com', 'emily_davis', 'http://www.example.com/avatar5.jpg', 'http://www.example.com/cover5.jpg');
INSERT INTO login_schema.users (name, email, date_of_birth, password, created_at, updated_at, email_verify_token, forgot_password_token, verify, bio, location, website, username, avatar, cover_photo) 
VALUES ('lcaohoanq', '', '2004-04-16', 'Luucaohoang1604', '2004-04-16', '2004-04-16', '', '', 'unverified', '', '', '', '', '', '');
INSERT INTO login_schema.users (name, email, date_of_birth, password, created_at, updated_at, email_verify_token, forgot_password_token, verify, bio, location, website, username, avatar, cover_photo) 
VALUES ('nmd', '', '', 'Luucaohoang1604', '2004-04-16', '2004-04-16', '', '', 'unverified', '', '', '', '', '', '');
INSERT INTO login_schema.users (name, email, date_of_birth, password, created_at, updated_at, email_verify_token, forgot_password_token, verify, bio, location, website, username, avatar, cover_photo) 
VALUES ('vy', '', '', 'Luucaohoang1604', '', '', '', '', 'unverified', '', '', '', '', '', '');

DELIMITER //

CREATE PROCEDURE InsertUser(
    IN p_name VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_date_of_birth DATE,
    IN p_password VARCHAR(255),
    IN p_created_at DATETIME,
    IN p_updated_at DATETIME,
    IN p_email_verify_token VARCHAR(255),
    IN p_forgot_password_token VARCHAR(255),
    IN p_verify VARCHAR(255),
    IN p_bio VARCHAR(255),
    IN p_location VARCHAR(255),
    IN p_website VARCHAR(255),
    IN p_username VARCHAR(255),
    IN p_avatar VARCHAR(255),
    IN p_cover_photo VARCHAR(255)
)
BEGIN
    INSERT INTO login_schema.users (
        name, email, date_of_birth, password, created_at, updated_at,
        email_verify_token, forgot_password_token, verify, bio, location,
        website, username, avatar, cover_photo
    )
    VALUES (
        p_name, p_email, p_date_of_birth, p_password, p_created_at, p_updated_at,
        p_email_verify_token, p_forgot_password_token, p_verify, p_bio, p_location,
        p_website, p_username, p_avatar, p_cover_photo
    );
END//

DELIMITER ;

CALL InsertUser('mnhw', '', NULL, 'Luucaohoang1604', '2004-04-16', NULL, '', '', 'unverified', '', '', '', '', '', '');
