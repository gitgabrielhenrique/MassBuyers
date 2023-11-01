package br.com.MassBuyers.MassBuyers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String nome;
private BigDecimal precovenda;
  private BigDecimal precorevenda;
private Long quantidade;

  @ManyToOne
    @JoinColumn(name = "subtipoid")
    private Subtipoprod subtipoprod;
  @JsonIgnore
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




  public BigDecimal getPrecovenda() {
    return precovenda;
  }

  public void setPrecovenda(BigDecimal precovenda) {
    this.precovenda = precovenda;
  }

  public BigDecimal getPrecorevenda() {
    return precorevenda;
  }

  public void setPrecorevenda(BigDecimal precorevenda) {
    this.precorevenda = precorevenda;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
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
