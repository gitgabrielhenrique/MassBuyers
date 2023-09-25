create table cidade(
id bigint primary key not null auto_increment,
nomecidade varchar(50) not null,
idestado bigint not null
);

insert into cidade(id, nomecidade, idestado) values(1,'lencois',1);
insert into cidade(id, nomecidade, idestado) values(2,'vitoria',2);
insert into cidade(id, nomecidade, idestado) values(3,'piraporinhadocaraio',1);


create table cliente(
id bigint not null auto_increment primary key,
nome varchar(150),
nascimento date,
email varchar(150),
senha varchar(75),
telefone int,
idcidade bigint not null
);

insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(1, 'serginho', '2020-10-06', 'serginhobochechas@gmail.com', 'bochechadebaixo', 1999831, 3);
insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(2, 'pirombo', '1860-10-25', 'piromboedaidademedia@gmail.com', 'idademedia', 199983, 3);
insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(3, 'grampa', '7070-05-07', 'grampafromthefuture07@gmail.com', 'bladerunner2043', 19999, 1);

insert into cliente(id, nome, nascimento, email, senha, telefone, idcidade) values(5, 'raul', '2006-01-13', 'lunaticos@gmail.com', 'gabrielmeupapai', 1499862, 1);


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

insert into fornecedor(id, cnpj, nome, telefone, descricao, email, senha, idcidade) values(1,12123,'junao',1499810,'vendedor de caixas','junao@gmail.com','gatinhosenha',1);
insert into fornecedor(id, cnpj, nome, telefone, descricao, email, senha, idcidade) values(2,124314,'sarah',1414141,'vendeodora de crack','culargo@gmail.com','bucetadormente',2);





create table produto(
id bigint primary key not null auto_increment,
nome varchar(50),
precovenda decimal(21,10),
precorevenda decimal(21,10),
quantidade int,
subtipoid bigint not null,
fornecedorid bigint not null
);
insert into produto(id,nome,precovenda,precorevenda,quantidade,subtipoid,fornecedorid) values(1,'caixa rosa',14.14,20.20,4,1,1);
insert into produto(id,nome,precovenda,precorevenda,quantidade,subtipoid,fornecedorid) values(2,'pedrade crack',1.14,10.20,5,2,2);





create table subtipoprod(
id bigint primary key not null auto_increment,
nome varchar(50),
tipoprodid bigint not null
);
insert into subtipoprod(id,nome,tipoprodid) values(1,'transporte',1);
insert into subtipoprod(id,nome,tipoprodid) values(2,'japones',2);







create table tipo_prod(
id bigint primary key not null auto_increment,
nome varchar(50)


);
insert into tipo_prod(id,nome)values(1,'utilidades');
insert into tipo_prod(id,nome)values(2,'alimentos');

create table venda(
id bigint primary key not null auto_increment,
data date,
idfornecedor bigint not null,
idcliente bigint not null,
idproduto bigint not null
);
insert into venda(id,data,idfornecedor,idcliente,idproduto)values(1,'2023-3-3',1,1,1);
insert into venda(id,data,idfornecedor,idcliente,idproduto) values(2,'2023-4-6',2,2,2);
