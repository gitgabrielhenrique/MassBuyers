package br.com.MassBuyers.MassBuyers.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="venda")
public class Venda {

  @Id
  private int id;
  private Date data;

 @ManyToOne
  @JoinColumn(name = "idproduto")
  private Produto produto;

  @ManyToOne
  @JoinColumn(name = "idfornecedor")
  private Fornecedor fornecedor;

  @ManyToOne
  @JoinColumn(name = "idcliente")
  private Cliente cliente;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
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
