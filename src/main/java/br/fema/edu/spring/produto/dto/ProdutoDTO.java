package br.fema.edu.spring.produto.dto;

import br.fema.edu.spring.categoria.model.*;
import br.fema.edu.spring.produto.model.*;

import java.util.*;
import java.util.stream.*;

public class ProdutoDTO {
    private Long id;
    private String nome;

    private Float valor;

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor  = produto.getValor();
        this.categoria = produto.getCategoria(this.categoria);
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

    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
