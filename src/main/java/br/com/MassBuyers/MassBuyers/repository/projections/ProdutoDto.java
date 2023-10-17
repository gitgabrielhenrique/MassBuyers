package br.com.MassBuyers.MassBuyers.repository.projections;

import java.math.BigDecimal;

public class ProdutoDto {
  private Long id;
  private String nome;
  private BigDecimal precovenda;
  private BigDecimal precorevenda;
  private Long quantidade;
  private String nomefornecedor;
  private String subtipoprod;

  public ProdutoDto(Long id, String nome, BigDecimal precovenda, BigDecimal precorevenda, Long quantidade, String nomefornecedor, String subtipoprod) {
    this.id = id;
    this.nome = nome;
    this.precovenda = precovenda;
    this.precorevenda = precorevenda;
    this.quantidade = quantidade;
    this.nomefornecedor = nomefornecedor;
    this.subtipoprod = subtipoprod;
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

  public String getNomefornecedor() {
    return nomefornecedor;
  }

  public void setNomefornecedor(String nomefornecedor) {
    this.nomefornecedor = nomefornecedor;
  }

  public String getSubtipoprod() {
    return subtipoprod;
  }

  public void setSubtipoprod(String subtipoprod) {
    this.subtipoprod = subtipoprod;
  }
}
