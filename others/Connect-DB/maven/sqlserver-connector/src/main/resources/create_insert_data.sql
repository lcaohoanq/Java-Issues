-- Create the database if it doesn't exist
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = N'users_schema')
CREATE DATABASE users_schema;

-- Use the database
USE users_schema;

-- Create the users table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'users') AND type in (N'U'))
CREATE TABLE users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(45) NOT NULL UNIQUE,
    password NVARCHAR(50) NOT NULL,
    score INT,
    reg_date NVARCHAR(50) NOT NULL
);

-- Insert values into the users table
INSERT INTO users (username, password, score, reg_date) VALUES
('hoang', '$31$16$tI3b31pfkwiVfW7u1_4LYcyzameV6gGm_fto0tEIBCI', 99, '2024-02-28'),
('toilaluu', '$31$16$EwBZ6WEqPfIPaeynRV63Nn8UhLOSucwkC7WBY7uAchk', 0, '2024-03-01'),
('duong', '$31$16$A2fFe83zAcbXOMeZ7NiMBnVOCD7actfU68aIkZE1rEA', 0, '2024-03-01'),
('huy', '$31$16$5uBNgudXH6BsSz4N7GbbrfjrqAMGh6TcoxDs6ruwnPI', 0, '2024-03-01'),
('bao', '$31$16$CrqpO_WzDPLWh9jCpPcKeqKv1VEHswyq3d7G6wZQpQg', 0, '2024-03-03'),
('minhnhu', '$31$16$xEeCSM_NeDhbLzpvpXAJpxdxGUR-dGI46UEH1paLa90', 0, '2024-03-03');


SELECT username, score FROM users;