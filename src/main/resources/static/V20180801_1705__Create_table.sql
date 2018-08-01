CREATE table todo(
id int primary key auto_increment,
name varchar,
status boolean,
completed boolean,
time varchar
);

CREATE TABLE Employee(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10),
    companyId INT NOT NULL,
    salary INT NOT NULL
) engine=InnoDB DEFAULT CHARSET = utf8;