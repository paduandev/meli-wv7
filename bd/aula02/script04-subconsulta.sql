-- quais são os filmes que não é o filme preferido de nenhum ator
-- todos os filmes menos os filmes que são preferencia de algum ator

select movies.title 
from movies
where not exists
(select * from actors where favorite_movie_id = movies.id);

select count(movies.title)
from movies
where exists
(select * from actors where favorite_movie_id = movies.id);

SELECT * FROM movies 
WHERE id NOT IN 
(SELECT favorite_movie_id FROM actors);

