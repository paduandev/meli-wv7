-- produto cartesiano (combinação) de todos os registros
select *
from produtos, fornecedores;

-- idem ao aonterior, com sintaxe atual
select *
from produtos Cross Join fornecedores;

-- agora filtrando somente os registros que 'fazem sentido'
select *
from produtos, fornecedores
where produtos.id_fornecedor = fornecedor.id;

-- quantos generos cadastrados
select count(*) from genres; -- 12

-- quantos filmes cadastrados
select count(*) from movies; -- 21

-- quantos registros no produtos das tabelas
select count(*) 
from genres cross join movies; -- 252

-- quantos registros depois de filtras as informações 'verdadeiras'
select count(*) 
from genres 
inner join movies on movies.genre_id = genres.id; -- 19

-- fimes sem generos cadastrados
select * from movies where genre_id is null;

-- inserindo um novo registro com a data atual de cadastro
insert into genres values(null, now(), null, 'Novo Genero', 20, 1);

-- filmes com seus generos, não incluindo filmes ou generos sem relação entre eles
select movies.title as filme, genres.name as genero
from genres inner join movies 
on movies.genre_id = genres.id; 

-- filmes com seus generos, incluindo filmes sem genero cadastrado
select movies.title as filme, genres.name as genero
from genres right join movies 
on movies.genre_id = genres.id; 

-- idem a consulta acima, escrida de outra forma
select movies.title as filme, genres.name as genero
from  movies left join genres 
on movies.genre_id = genres.id; 

-- filmes com seus generos, incluindo generos que não estão relacionados a nenhum filme
select movies.title as filme, genres.name as genero
from genres left join movies 
on movies.genre_id = genres.id; 

-- todos os filmes e generos, incluindo não relacionados (full outer join)
select movies.title as filme, genres.name as genero
from genres left join movies 
on movies.genre_id = genres.id
Union 
select movies.title as filme, genres.name as genero
from genres right join movies 
on movies.genre_id = genres.id;

-- quais são os generos que não aparecem em nenhum filme
select * 
from movies right join genres on movies.genre_id = genres.id
where movies.genre_id is null;

