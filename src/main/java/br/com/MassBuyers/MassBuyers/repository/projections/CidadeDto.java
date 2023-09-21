package br.com.MassBuyers.MassBuyers.repository.projections;

public class CidadeDto {
  private Long id;
  private String nome;
  private String nomestado;

  public CidadeDto(Long id, String nome, String nomestado) {
    this.id = id;
    this.nome = nome;
    this.nomestado = nomestado;
  }

  public Long getIdcidad() {
    return id;
  }

  public void setIdcidad(Long idcidad) {
    this.id = idcidad;
  }

  public String getNomecidade() {
    return nome;
  }

  public void setNomecidade(String nomecidade) {
    this.nome= nomecidade;
  }

  public String getNomestado() {
    return nomestado;
  }

  public void setNomestado(String nomestado) {
    this.nomestado = nomestado;
  }
}
