drop table if exists items;

create table items (
	name		varchar(32),
	price		decimal(8,2),
	quantity	integer
);

insert into items values ('milk', 3.89, 2);
insert into items values ('beer', 6.99, 1);
