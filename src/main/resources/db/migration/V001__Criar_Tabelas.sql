create table cidade(

id bigint primary key not null auto_increment,
nome varchar(50),
idestado varchar(45)
);

create table estado(
id bigint primary key not null auto_increment,
nome varchar(50)
);

create table  fornecedor(
id bigint primary key not null auto_increment,
cnpj bigint

);
