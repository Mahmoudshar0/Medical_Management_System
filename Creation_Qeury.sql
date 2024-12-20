CREATE DATABASE MedicalClinic;
USE MedicalClinic;

CREATE TABLE UserLogin (
    UserID INT PRIMARY KEY,
    Username VARCHAR(20) NOT NULL UNIQUE,
    Password VARCHAR(100) NOT NULL,
    Role VARCHAR(15) NOT NULL
);

CREATE TABLE Patients (
    PatientID INT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    DateOfBirth DATE NOT NULL,
    Phone VARCHAR(15),
    Email VARCHAR(100),
    Address TEXT,
    Gender VARCHAR(10) NOT NULL
);

CREATE TABLE Doctors (
    DoctorID INT PRIMARY KEY,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    Specialization VARCHAR(50),
    Phone VARCHAR(15),
    Email VARCHAR(70),
    RoomNumber VARCHAR(10)
);

CREATE TABLE Appointments (
    AppointmentID INT PRIMARY KEY,
    PatientID INT NOT NULL,
    DoctorID INT NOT NULL,
    AppointmentDate DATETIME NOT NULL,
    Status VARCHAR(25) NOT NULL,
-- ('Scheduled', 'Completed', 'Cancelled')
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);

CREATE TABLE MedicalRecords (
    RecordID INT PRIMARY KEY,
    PatientID INT NOT NULL,
    DoctorID INT NOT NULL,
    RecordDate DATE NOT NULL,
    Description TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);
