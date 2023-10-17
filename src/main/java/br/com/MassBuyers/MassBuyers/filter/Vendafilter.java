package br.com.MassBuyers.MassBuyers.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Vendafilter {
  private Long id;
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private LocalDate datavenda;
private String nomefornecedor;
private String nomecliente;
private String nomeproduto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDatavenda() {
    return datavenda;
  }

  public void setDatavenda(LocalDate datavenda) {
    this.datavenda = datavenda;
  }

  public String getNomefornecedor() {
    return nomefornecedor;
  }

  public void setNomefornecedor(String nomefornecedor) {
    this.nomefornecedor = nomefornecedor;
  }

  public String getNomecliente() {
    return nomecliente;
  }

  public void setNomecliente(String nomecliente) {
    this.nomecliente = nomecliente;
  }

  public String getNomeproduto() {
    return nomeproduto;
  }

  public void setNomeproduto(String nomeproduto) {
    this.nomeproduto = nomeproduto;
  }
}
