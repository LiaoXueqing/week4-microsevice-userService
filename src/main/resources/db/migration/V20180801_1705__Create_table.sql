CREATE table User(
    id int primary key auto_increment,
    name VARCHAR(255),
    password VARCHAR(255)
);
CREATE table Todo(
    id int primary key auto_increment,
    name VARCHAR(255),
    deleted TINYINT,
    completed BOOLEAN,
    time DATETIME,
    user_id INT,
    foreign key (user_id) references user(id)
);
CREATE TABLE Task(
    id INT PRIMARY KEY auto_increment,
    content VARCHAR(255),
    todo_id INT,
    foreign key (todo_id) references todo(id)
);