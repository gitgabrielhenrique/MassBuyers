package br.com.MassBuyers.MassBuyers.model;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String nome;


    @ManyToOne
    @JoinColumn(name = "subtipoid")
    private Subtipoprod subtipoprod;


}
