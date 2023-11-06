package br.fema.edu.spring.produto.service;

import br.fema.edu.spring.categoria.dto.CategoriaDTO;
import br.fema.edu.spring.categoria.form.CategoriaFORM;
import br.fema.edu.spring.categoria.model.Categoria;
import br.fema.edu.spring.categoria.repository.*;
import br.fema.edu.spring.produto.dto.*;
import br.fema.edu.spring.produto.form.ProdutoForm;
import br.fema.edu.spring.produto.model.*;
import br.fema.edu.spring.produto.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.*;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        List<Produto> produtos =
        this.produtoRepository.findAll();
        return ResponseEntity.ok(ProdutoDTO.converter(produtos));
    }

    @GetMapping
    public ResponseEntity<ProdutoDTO> listarProdutosPorId(Long idProduto){
        Optional<Produto> optionalProduto = this.produtoRepository.findById(idProduto);
        if(!optionalProduto.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Produto produto = optionalProduto.get();
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(ProdutoForm formulario){
        Produto produto = new Produto();
        produto.setValor(formulario.getValor());
        produto.setNome(formulario.getNome());
        produto.setCategoria(formulario.getCategoria());
        produto = produtoRepository.save(produto);
        new ProdutoDTO(produto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ProdutoDTO> atualizarProduto(Long idProduto, ProdutoForm formulario){
        Produto produto = this.buscarProduto(idProduto);
        produto.setNome(formulario.getNome());
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<ProdutoDTO> deletarProduto(Long idProduto) {
        this.produtoRepository.delete(this.buscarProduto(idProduto));
        return ResponseEntity.ok().build();
    }


    public Produto buscarProduto(Long idProduto) {
        Optional<Produto> optionalProduto = this.produtoRepository.findById(idProduto);
        if (!optionalProduto.isPresent()) {
            return null;
        }
        return optionalProduto.get();
    }
}
