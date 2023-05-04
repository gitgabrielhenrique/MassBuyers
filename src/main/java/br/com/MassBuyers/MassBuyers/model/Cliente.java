package br.com.MassBuyers.MassBuyers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
  private int id;
  private String nome;
  private String email;
  private Date nascimento;
  private  String senha;
  private int telefone;

  @ManyToOne
  @JoinColumn(name="idcidade")
  private Cidade cidade;

  @OneToMany (mappedBy = "cliente")
  private List<Venda> vendas= new ArrayList<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public int getTelefone() {
    return telefone;
  }

  public void setTelefone(int telefone) {
    this.telefone = telefone;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  public List<Venda> getVendas() {
    return vendas;
  }

  public void setVendas(List<Venda> vendas) {
    this.vendas = vendas;
  }
}
