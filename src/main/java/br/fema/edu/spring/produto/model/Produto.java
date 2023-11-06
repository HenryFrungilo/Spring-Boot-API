package br.fema.edu.spring.produto.model;

import br.fema.edu.spring.categoria.model.*;
import com.sun.istack.*;

import javax.persistence.*;

@Entity
@Table(name="Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    @Column(name="valor_produto")
    private Float valor;
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Produto(Long id, String nome, Float valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Produto() {

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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Categoria getCategoria(Categoria categoria) {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
