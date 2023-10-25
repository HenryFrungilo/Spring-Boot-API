package br.fema.edu.spring.produto.service;

import br.fema.edu.spring.categoria.repository.*;
import br.fema.edu.spring.produto.dto.*;
import br.fema.edu.spring.produto.model.*;
import br.fema.edu.spring.produto.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

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
}
