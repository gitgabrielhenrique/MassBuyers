package br.com.MassBuyers.MassBuyers.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Clientefilter {
  private Long id;
  private String nome;
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private LocalDate datanascimento;
  private String email;
  private String senha;
  private Long telefone;
  private String nomecidade;
  private String nomeestado;

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

  public LocalDate getDatanascimento() {
    return datanascimento;
  }

  public void setDatanascimento(LocalDate datanascimento) {
    this.datanascimento = datanascimento;
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
