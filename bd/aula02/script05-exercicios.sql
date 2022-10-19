-- quantas temporadas estão cadastradas
select count(*) as qtde_temporadas from seasons;

-- quantas temporadas existem para cada série
select series.title , count(*) as temporadas
from seasons inner join series on series.id = seasons.serie_id
group by series.id;

-- quantas temporadas existem para a série 'The Walking Dead'
select series.title , count(*) as temporadas
from seasons inner join series on series.id = seasons.serie_id
where series.title = 'The Walking Dead'
group by series.id;

-- quais series tem mais de 5 temporadas
select series.title , count(*) as temporadas
from seasons inner join series on series.id = seasons.serie_id
group by series.id
having temporadas > 5;


-- dúvida: se quiser mostrar apenas os nomes:
select series.title 
from seasons inner join series on series.id = seasons.serie_id
group by series.id
having count(*) > 5;

-- quais as 3 series com maior número de temporadas
select series.title , count(*) as temporadas
from seasons inner join series on series.id = seasons.serie_id
group by series.id
order by temporadas desc
limit 3;

-- Quais os nomes dos atores que trabalham em filmes com avaliação maior que 9.1
-- 1. subconsulta: seleciona os ids dos atores que estão em filmes com avaliaçao > 9.1 
-- 2. busca os nomes dos ids selecionados no passo 1
select first_name, last_name
from actors
where id in (
	select am.actor_id
	from movies m inner join actor_movie am on m.id = am.movie_id 
    where rating > 9.1
) order by first_name;

-- outra solução usando join
select first_name, last_name
from movies inner join actor_movie on movies.id = actor_movie.movie_id
			inner join actors on actors.id = actor_movie.actor_id
where movies.rating > 9.1
order by first_name;


