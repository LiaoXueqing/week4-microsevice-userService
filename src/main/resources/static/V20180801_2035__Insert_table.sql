insert into todo(name,deleted,completed,time,user_id)
values
("todo 1",false,false,NOW(),1),
("todo 2",false,false,NOW(),1),
("todo 3",false,false,NOW(),1),
("todo 4",false,false,NOW(),2),
("todo 5",false,false,NOW(),2),
("todo 6",false,false,NOW(),2),
("todo 7",false,false,NOW(),2),
("todo 8",false,false,NOW(),1);
insert into todo(name,deleted,completed,time,user_id) values ("todo 2",false,false,NOW(),1);
insert into task(content,todo_id)
values
("task 1",1),
("task 2",1),
("task 1",3),
("task 2",3),
("task 3",3),
("task 1",4);