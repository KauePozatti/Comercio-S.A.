create database comercio_sa;
use comercio_sa;

create table clientes
(
id_clientes int auto_increment primary key,
nome varchar(100) not null,
cpf char(11),
data_nascimento date not null,
endereco text
);

set sql_safe_updates=0;

create table contatos
(
id_contatos int auto_increment primary key,
contato enum("telefone","e-mail") not null,
valor varchar(255),
observacao text,
clientes_id int,
foreign key (clientes_id) references clientes(id_clientes) on delete cascade
);
describe contatos;
describe clientes;

insert into clientes(nome, cpf, data_nascimento, endereco) values
('Kauê Douglas','54657687657','2005-07-11','Rua Cambará, 1360 - São Paulo'),
('Paula Andrade','54657687658','1984-10-24','Rua Cambará, 1231 - São Paulo'),
('Douglas Pozatti','54657687659','1982-02-9','Rua Cambará, 1430 - São Paulo');

insert into contatos(contato, valor, observacao, clientes_id) values
('e-mail','kauepozzati@gmail.com','e-mail corporativo','1'),
('telefone','11954442098','celular pessoal','2'),
('telefone','11986109526','celular pessoal','3');

select * from clientes;

select * from clientes where nome like 'Kauê Douglas' or cpf = '54657687657';

select * from contatos where id_contatos = 2;

update clientes set nome = 'Kauê Pozatti' where nome = 'Kauê Douglas';
select * from clientes;

delete from contatos where id_contatos = 2;
select * from contatos;

delete from clientes where nome = 'Kauê Pozatti';
select * from clientes;
