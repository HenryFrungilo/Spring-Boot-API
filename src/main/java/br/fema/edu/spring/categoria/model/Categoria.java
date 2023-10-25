package br.fema.edu.spring.categoria.model;

import com.sun.istack.*;

import javax.persistence.*;

@Entity
@Table(name="Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;
    @NotNull
    private String nome;

    public Categoria(){	}

    public Categoria(Long id, String descricao) {
        this.id = id;
        this.nome = descricao;
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
}
