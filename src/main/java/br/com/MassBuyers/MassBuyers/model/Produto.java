package br.com.MassBuyers.MassBuyers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String nome;
private double precovenda;
  private double precorevenda;
private int quantidade;

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getPrecovenda() {
    return precovenda;
  }

  public void setPrecovenda(double precovenda) {
    this.precovenda = precovenda;
  }

  public double getPrecorevenda() {
    return precorevenda;
  }

  public void setPrecorevenda(double precorevenda) {
    this.precorevenda = precorevenda;
  }

  @ManyToOne
    @JoinColumn(name = "subtipoid")
    private Subtipoprod subtipoprod;

    @OneToMany(mappedBy = "produto")
    private List<Venda> vendas=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="fornecedorid")
    private Fornecedor fornecedor;


  public List<Venda> getVendas() {
    return vendas;
  }

  public void setVendas(List<Venda> vendas) {
    this.vendas = vendas;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Subtipoprod getSubtipoprod() {
    return subtipoprod;
  }

  public void setSubtipoprod(Subtipoprod subtipoprod) {
    this.subtipoprod = subtipoprod;
  }
}
