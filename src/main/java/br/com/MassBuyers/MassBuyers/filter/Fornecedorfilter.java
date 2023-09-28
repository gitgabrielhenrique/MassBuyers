package br.com.MassBuyers.MassBuyers.filter;

public class Fornecedorfilter {
  private  String nomefornecedor;
  private Long cnpj;
  private Long telefone;
  private String descricao;
  private String email;
  private String senha;
  private String nomecidade;
  private String nomeestado;

  public String getNomefornecedor() {
    return nomefornecedor;
  }

  public void setNomefornecedor(String nomefornecedor) {
    this.nomefornecedor = nomefornecedor;
  }

  public Long getCnpj() {
    return cnpj;
  }

  public void setCnpj(Long cnpj) {
    this.cnpj = cnpj;
  }

  public Long getTelefone() {
    return telefone;
  }

  public void setTelefone(Long telefone) {
    this.telefone = telefone;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
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
