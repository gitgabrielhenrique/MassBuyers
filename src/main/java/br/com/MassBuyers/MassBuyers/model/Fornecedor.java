package br.com.MassBuyers.MassBuyers.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="fornecedor")
public class Fornecedor {
@Id
  private Long id;

private Long cnpj;
private Long telefone;
private String descricao;
private String email;
  private String senha;

  @ManyToOne
  @JoinColumn(name="idcidade")
  private Cidade cidade;

  @OneToMany(mappedBy = "fornecedor")
  private List<Produto> produto=new ArrayList<>();

  @OneToMany(mappedBy = "fornecedor")
  private List<Venda> vendas=new ArrayList<>();
}
