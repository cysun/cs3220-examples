drop table if exists employees;

create table employees (
    id          integer auto_increment primary key,
    username    varchar(255) unique,
    password    varchar(255),
    birthday    date,
    salary      decimal(12,2)
);

insert into employees (username,password,birthday,salary) values
    ('john', 'abc', '1970-1-1', 40000.00);
insert into employees (username,password,birthday,salary) values
    ('jane', '123', '1980-3-3', 60000.00);
insert into employees (username,password,birthday,salary) values
    ('joe', 'xyz', '1975-2-2', 50000.00);
