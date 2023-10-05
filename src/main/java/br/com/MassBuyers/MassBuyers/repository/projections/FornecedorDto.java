package br.com.MassBuyers.MassBuyers.repository.projections;

public class FornecedorDto {

  private Long id;
  private String nome;
  private Long cnpj;
  private Long telefone;
  private String descricao;
  private String email;
  private String senha;
  private String nomecidade;
  private String nomeestado;

  public FornecedorDto(Long id, String nome, Long cnpj, Long telefone, String descricao, String email, String senha, String nomecidade, String nomeestado) {
    this.id = id;
    this.nome = nome;
    this.cnpj = cnpj;
    this.telefone = telefone;
    this.descricao = descricao;
    this.email = email;
    this.senha = senha;
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
