package br.com.MassBuyers.MassBuyers.repository.projections;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ClienteDto {
  private Long id;
  private String nome;
  private LocalDate nascimento;
  private String email;
  private String senha;
  private Long telefone;
  private String nomecidade;
  private String nomeestado;

  public ClienteDto(Long id, String nome, LocalDate nascimento, String email, String senha, Long telefone, String nomecidade, String nomeestado) {
    this.id = id;
    this.nome = nome;
    this.nascimento = nascimento;
    this.email = email;
    this.senha = senha;
    this.telefone = telefone;
    this.nomecidade = nomecidade;
    this.nomeestado = nomeestado;
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

  public LocalDate getNascimento() {
    return nascimento;
  }

  public void setNascimento(LocalDate nascimento) {
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

  public String getNomecidade() {
    return nomecidade;
  }

  public void setNomecidade(String nomecidade) {
    this.nomecidade = nomecidade;
  }

  public String getNomeestado() {
    return nomeestado;
  }

  public void setNomeestado(String nomeestado) {
    this.nomeestado = nomeestado;
  }
}
