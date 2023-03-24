package br.com.MassBuyers.MassBuyers.model;

import javax.persistence.*;

@Entity
@Table(name="sub_tipoprod")
public class Subtipoprod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "tipoprodid")
    private Tipoprod tipoprod;
}
