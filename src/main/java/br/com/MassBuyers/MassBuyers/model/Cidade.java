package br.com.MassBuyers.MassBuyers.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cidade")
public class Cidade {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
  private String nomecidade;

@ManyToOne
@JoinColumn(name = "idestado")
private Estado estado;
  @JsonIgnore
@OneToMany(mappedBy = "cidade")
private List<Fornecedor> fornecedor= new ArrayList<>();
  @JsonIgnore
  @OneToMany(mappedBy = "cidade")
  private List<Cliente> clientes= new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  public String getNomecidade() {
    return nomecidade;
  }

  public void setNomecidade(String nomecidade) {
    this.nomecidade = nomecidade;
  }

  public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


  public List<Fornecedor> getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(List<Fornecedor> fornecedor) {
    this.fornecedor = fornecedor;
  }

  public List<Cliente> getClientes() {
    return clientes;
  }

  public void setClientes(List<Cliente> clientes) {
    this.clientes = clientes;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
