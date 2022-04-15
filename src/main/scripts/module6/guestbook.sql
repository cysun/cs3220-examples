drop table if exists guestbook;

create table guestbook(
	id		integer auto_increment primary key,
	name	varchar(255),
	message	varchar(255)
);

insert into guestbook (name, message) values ('John', 'Hi!');
insert into guestbook (name, message) values ('Jane', 'Hello');
