package br.com.MassBuyers.MassBuyers.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="venda")
public class Venda {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate datavenda;

 @ManyToOne
  @JoinColumn(name = "idproduto")
  private Produto produto;

  @ManyToOne
  @JoinColumn(name = "idfornecedor")
  private Fornecedor fornecedor;

  @ManyToOne
  @JoinColumn(name = "idcliente")
  private Cliente cliente;

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

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
