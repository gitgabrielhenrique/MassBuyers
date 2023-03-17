package br.com.MassBuyers.MassBuyers.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="estado")
public class Estado {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nome;

@OneToMany(mappedBy = "estado")
private List <Cidade> cidadeestado = new ArrayList<>();


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

    public List<Cidade> getCidadeestado() {
        return cidadeestado;
    }

    public void setCidadeestado(List<Cidade> cidadeestado) {
        this.cidadeestado = cidadeestado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return id.equals(estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
