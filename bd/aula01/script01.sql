# Cria um novo Banco de Dados
create database bd_aula1_meli;

# indica qual o banco default(padrão)
use bd_aula1_meli;

# cria uma nova tabela chamada produto
create table produto (
	id integer,
    nome varchar(100) not null,
    preco double default 0,
    primary key(id)
);

# insere um registro na table de produtos
insert into produto values (1, 'Teclado', 150);
insert into produto values (2, 'Mouse', 50);
insert into produto values (3, 'Mouse Gamer', 200);
insert into produto values (1, null, 150);

# busque todos os campos de todos os registros da tabela de produtos
select * from produto;

# Busque os nomes e preços dos produtos cadastrados
select nome, preco from produto;

# busque as informações do produto com código 2
select * 
from produto 
where id = 2;

# busque todos os preços de mouses
select nome, preco
from produto
where nome like "%mouse%";


