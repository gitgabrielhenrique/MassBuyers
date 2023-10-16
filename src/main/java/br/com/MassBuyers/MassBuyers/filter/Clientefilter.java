package br.com.MassBuyers.MassBuyers.filter;

import java.util.Date;

public class Clientefilter {
  private String nome;
  private Date nascimento;
  private String email;
  private String senha;
  private Long telefone;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(Date nascimento) {
    this.nascimento = nascimento;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Long getTelefone() {
    return telefone;
  }

  public void setTelefone(Long telefone) {
    this.telefone = telefone;
  }
}
