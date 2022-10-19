use movies_db_meli;

create table actors_temp
select first_name, last_name
from actors
where rating > 5;

select * from actors_temp;

select first_name from actors_temp where first_name like '%Sam%';