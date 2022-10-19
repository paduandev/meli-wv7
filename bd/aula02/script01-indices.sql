create database bd_indice_meli;

use bd_indice_meli;

create table user (
	id integer,
    nome varchar(100)
);

insert into user values(1, 'Marcos');
insert into user values(1, 'Fabiana');

select distinct nome from user;

update user set id = 2 where nome = 'Fabiana';

alter table user
add constraint primary key(id);

select * from user
where id = 2;

select * from user
where nome = 'Fabiana';

alter table user
add email varchar(100);

select * from user;

update user set email = 'marcos@email.com' where id = 2;

alter table user
add constraint unique(email);

select * from user
where email = 'marcos@email.com';

