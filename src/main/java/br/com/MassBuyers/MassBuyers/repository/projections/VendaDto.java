package br.com.MassBuyers.MassBuyers.repository.projections;

import java.time.LocalDate;

public class VendaDto {
  private Long id;
 // private LocalDate registrovenda;
 private LocalDate datavenda;
  private String nomefornecedor;
  private String nomecliente;
  private String nomeproduto;

  public VendaDto(Long id, LocalDate datavenda, String nomefornecedor, String nomecliente, String nomeproduto) {
    this.id = id;
    this.datavenda = datavenda;
    this.nomefornecedor = nomefornecedor;
    this.nomecliente = nomecliente;
    this.nomeproduto = nomeproduto;
  }

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
