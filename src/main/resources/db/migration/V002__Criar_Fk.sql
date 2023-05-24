Alter table subtipoprod add constraint FK_subtipo_tipo FOREIGN key (tipoprodid) references tipoprod(id);
Alter table produto add constraint FK_produto_subtipo FOREIGN key (subtipoid) references subtipoprod(id);
Alter table produto add constraint FK_produto_fornecedor FOREIGN key (fornecedorid) references fornecedor(id);
Alter table venda add constraint FK_venda_produto FOREIGN key (idproduto) references produto(id);
Alter table venda add constraint FK_venda_fornecedor FOREIGN key (idfornecedor) references fornecedor(id);
Alter table venda add constraint FK_venda_cliente FOREIGN key (idcliente) references cliente(id);

Alter table fornecedor add constraint FK_fornecedor_cidade FOREIGN key (idcidade) references cidade(id);
Alter table cliente add constraint FK_cliente_cidade FOREIGN key (idcidade) references cidade(id);


Alter table cidade add constraint FK_cidade_estado FOREIGN key (idestado) references estado(id);
