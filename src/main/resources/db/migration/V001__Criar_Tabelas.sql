create table cidade(
id bigint primary key not null auto_increment,
nome varchar(50) not null,
idestado bigint not null
);

insert into cidade(id, nome, idestado) values(1,'lencois',1);
insert into cidade(id, nome, idestado) values(2,'vitoria',2);
insert into cidade(id, nome, idestado) values(3,'piraporinhadocaraio',1)


create table cliente(
id bigint not null auto_increment primary key,
nome varchar(150),
nascimento date,
email varchar(150),
senha varchar(75),
telefone int,
idcidade bigint not null
);

insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(1, 'serginho', '2020-10-06', 'serginhobochechas@gmail.com', 'bochechadebaixo', '19998314733', 3);
insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(2, 'pirombo', '1860-10-25', 'piromboedaidademedia@gmail.com', 'idademedia', '19998314555', 3);
insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(3, 'grampa', '7070-05-07', 'grampafromthefuture07@gmail.com', 'bladerunner2043', '19999999999', 1);
insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(4, 'sazinhp', '2020-02-33', 'sazinhopontocom@gmail.com', 'fazmeu', '196687954309', 2);
insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(5, 'raul', '2006-01-13', 'lunaticos@gmail.com', 'gabrielmeupapai', '14998620607', 1);


create table estado(
id bigint not null auto_increment primary key,
nome varchar(50)
);

insert into estado(id, nome) values(1,'sao paulo');
insert into estado(id, nome) values(2,'espirito santo');


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

insert into fornecedor(id, cnpj, nome, telefone, descricao, email, senha, idcidade) values();
insert into fornecedor(id, cnpj, nome, telefone, descricao, email, senha, idcidade) values();
insert into fornecedor(id, cnpj, nome, telefone, descricao, email, senha, idcidade) values();
insert into fornecedor(id, cnpj, nome, telefone, descricao, email, senha, idcidade) values();
insert into fornecedor(id, cnpj, nome, telefone, descricao, email, senha, idcidade) values();





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
nome varchar(50),
tipoprodid bigint  not null
);








create table tipo_prod(
id bigint primary key not null auto_increment,
nome varchar(50)


);

create table venda(
id bigint primary key not null auto_increment,
data date,
idfornecedor bigint not null,
idcliente bigint not null,
idproduto bigint not null
);
