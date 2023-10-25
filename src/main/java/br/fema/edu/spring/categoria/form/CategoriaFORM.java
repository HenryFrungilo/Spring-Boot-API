package br.fema.edu.spring.categoria.form;

import br.fema.edu.spring.categoria.dto.*;
import br.fema.edu.spring.categoria.model.*;

public class CategoriaFORM {
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter(Categoria categoria){
        categoria.setNome(this.nome);
        return categoria;
    }
}
