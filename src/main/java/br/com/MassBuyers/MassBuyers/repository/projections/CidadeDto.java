package br.com.MassBuyers.MassBuyers.repository.projections;

public class CidadeDto {
  private Long id;
  private String nomecidade;
  private String nomeestado;


  public CidadeDto(Long id, String nomecidade, String nomeestado) {
    this.id = id;
    this.nomecidade = nomecidade;
    this.nomeestado = nomeestado;
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

  public String getNomeestado() {
    return nomeestado;
  }

  public void setNomeestado(String nomeestado) {
    this.nomeestado = nomeestado;
  }
}

