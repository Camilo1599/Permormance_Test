CREATE DATABASE riwiAcademyDB;

USE riwiAcademyDB;

CREATE TABLE students(
	id int primary key auto_increment,
    name varchar(100) NOT NULL,
    lastname varchar(100) NOT NULL,
    email varchar(100) NOT NULL unique,
	document varchar(100) NOT NULL,
    status enum('ACTIVO', 'INACTIVO') default 'ACTIVO'
);

CREATE TABLE courses(
	id int primary key auto_increment,
    name varchar(100) NOT NULL unique NOT NULL,
    number_student int NOT NULL
);

CREATE TABLE registrations(
	id int primary key auto_increment,
    course_id int NOT NULL,
    student_id int NOT NULL,
    foreign key (course_id) references courses(id) ON DELETE CASCADE,
    foreign key (student_id) references students(id)
);

CREATE TABLE grades(
	id int primary key auto_increment,
    grade double NOT NULL,
    grade_type enum('Exam','Quiz', 'Workshop', 'Homework'),
    registration_id int NOT NULL,
    foreign key (registration_id) references registrations(id) ON DELETE CASCADE
);
