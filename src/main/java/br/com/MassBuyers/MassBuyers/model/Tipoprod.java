package br.com.MassBuyers.MassBuyers.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipo_prod")
public class Tipoprod {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipoprod tipoprod = (Tipoprod) o;
        return id.equals(tipoprod.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
