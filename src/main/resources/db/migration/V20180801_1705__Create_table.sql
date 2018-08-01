CREATE table Todo(
    id int primary key auto_increment,
    name VARCHAR(255),
    status TINYINT,
    completed BOOLEAN,
    time DATETIME
)