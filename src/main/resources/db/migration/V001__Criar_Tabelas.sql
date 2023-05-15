create table cidade(

id bigint primary key not null auto_increment,
nome varchar(50),
idestado varchar(45)
);

create table cliente(
id bigint primary key not null auto_increment,
 nome varchar(150),
 nascimento date,
email varchar(150),
senha varchar(75),
telefone int,
idestado bigint not null
);

create table estado(
id bigint primary key not null auto_increment,
nome varchar(50)
);

create table  fornecedor(
id bigint primary key not null auto_increment,
cnpj bigint,
nome varchar(50),
telefone int,
descricao varchar (250),
email varchar(150),
senha varchar(75),
idcidade bigint not null

);

create table produto(
id bigint primary key not null auto_increment,
nome varchar(50),
precovenda decimal(9,9),
precorevenda decimal(9,9),
quantidade int,
subtipoid bigint not null,
fornecedorid bigint not null
);

create table subtipoprod(
id bigint primary key not null auto_increment,
nome varchar(50)
);

create table tipoprod(
id bigint primary key not null auto_increment,
nome varchar(50)


);

create table vendas(
id bigint primary key not null auto_increment,
data date,
idfornecedor bigint not null,
idcliente bigint not null,
idproduto bigint not null
);
