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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCnpj() {
    return cnpj;
  }

  public void setCnpj(Long cnpj) {
    this.cnpj = cnpj;
  }

  public Long getTelefone() {
    return telefone;
  }

  public void setTelefone(Long telefone) {
    this.telefone = telefone;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  public List<Produto> getProduto() {
    return produto;
  }

  public void setProduto(List<Produto> produto) {
    this.produto = produto;
  }

  public List<Venda> getVendas() {
    return vendas;
  }

  public void setVendas(List<Venda> vendas) {
    this.vendas = vendas;
  }

  @ManyToOne
  @JoinColumn(name="idcidade")
  private Cidade cidade;

  @OneToMany(mappedBy = "fornecedor")
  private List<Produto> produto=new ArrayList<>();

  @OneToMany(mappedBy = "fornecedor")
  private List<Venda> vendas=new ArrayList<>();
}
