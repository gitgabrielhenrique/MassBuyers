package br.com.MassBuyers.MassBuyers.repository.projections;

public class CidadeDto {
  private Long id;
  private String nomecidade;
  private String nome;

  public CidadeDto(Long id, String nomecidade, String nome) {
    this.id = id;
    this.nomecidade = nomecidade;
    this.nome = nome;
  }

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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}

