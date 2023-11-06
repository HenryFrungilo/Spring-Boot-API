package br.fema.edu.spring.produto.form;

import br.fema.edu.spring.categoria.model.Categoria;
import br.fema.edu.spring.produto.model.Produto;

public class ProdutoForm {
    private String nome;

    private Float valor;

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public Float getValor(){ return valor;}

    public Produto converter(Produto produto){
        produto.setNome(this.nome);
        produto.setValor(this.valor);
        produto.getCategoria(this.categoria);
        return produto;
    }
}
