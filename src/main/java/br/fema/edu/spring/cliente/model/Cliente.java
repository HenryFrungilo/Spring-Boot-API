package br.fema.edu.spring.cliente.model;

import com.sun.istack.*;

import javax.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private String rg;

}
