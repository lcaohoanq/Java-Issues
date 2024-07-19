CREATE DATABASE appointment_schedules

GO

USE appointment_schedules

GO

CREATE TABLE Users (
    id INT PRIMARY KEY IDENTITY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE Appointments (
    id INT PRIMARY KEY IDENTITY,
    userId INT,
    appointmentDate DATE,
    appointmentTime TIME,
    purpose VARCHAR(255),
    status VARCHAR(50),
    FOREIGN KEY (userId) REFERENCES Users(id)
);