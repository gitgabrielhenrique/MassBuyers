package br.com.MassBuyers.MassBuyers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subtipoprod")
public class Subtipoprod {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "tipoprodid")
    private Tipoprod tipoprod;
  @JsonIgnore
    @OneToMany(mappedBy = "subtipoprod")
  private List<Produto> produto=new ArrayList<>();

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

  public Tipoprod getTipoprod() {
    return tipoprod;
  }

  public void setTipoprod(Tipoprod tipoprod) {
    this.tipoprod = tipoprod;
  }

  public List<Produto> getProduto() {
    return produto;
  }

  public void setProduto(List<Produto> produto) {
    this.produto = produto;
  }
}
