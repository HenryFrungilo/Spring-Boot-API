package br.fema.edu.spring.categoria.dto;

import br.fema.edu.spring.categoria.model.*;

import java.util.*;
import java.util.stream.*;

public class CategoriaDTO {
    private Long id;
    private String nome;
    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
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

    public static List<CategoriaDTO> converter(List<Categoria> categorias){
        return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }
}
