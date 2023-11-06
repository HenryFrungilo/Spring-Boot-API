package br.fema.edu.spring.categoria.service;

import br.fema.edu.spring.categoria.dto.*;
import br.fema.edu.spring.categoria.form.*;
import br.fema.edu.spring.categoria.model.*;
import br.fema.edu.spring.categoria.repository.*;
import br.fema.edu.spring.exception.model.ExceptionModel;
import br.fema.edu.spring.produto.model.Produto;
import br.fema.edu.spring.produto.repository.ProdutoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias(){
        List<Categoria> categorias = this.categoriaRepository.findAll();
        return ResponseEntity.ok(CategoriaDTO.converter(categorias));
    }

    @GetMapping
    public ResponseEntity<CategoriaDTO> buscarCategoriasPorId(Long idCategoria){
        Optional<Categoria> optionalCategoria = this.categoriaRepository.findById(idCategoria);
        if(!optionalCategoria.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Categoria categoria = optionalCategoria.get();
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }
    @PostMapping
    public ResponseEntity<CategoriaDTO> cadastrarNovaCategoria (CategoriaFORM formulario){
        Categoria categoria = new Categoria();
        categoria.setNome(formulario.getNome());
        categoria = categoriaRepository.save(categoria);
        new CategoriaDTO(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<CategoriaDTO> atualizarCategoria(Long idCategoria, CategoriaFORM formulario) {
        Categoria categoria = this.buscarCategoria(idCategoria);
        categoria.setNome(formulario.getNome());
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<CategoriaDTO> deletarCategoria(Long idCategoria) {
        Categoria categoria = this.buscarCategoria(idCategoria);
        this.categoriaRepository.deleteById(categoria.getId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<CategoriaDTO> deletarElementosPeloURL(Long idCategoria) {
        if(this.produtoRepository.findAllByCategoria_Id(idCategoria).isEmpty()){
            this.categoriaRepository.delete(this.buscarCategoria(idCategoria));
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            this.produtoRepository.deleteByCategoria_Id(idCategoria);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    public Categoria buscarCategoria(Long idCategoria){
        Optional<Categoria> optionalCategoria = this.categoriaRepository.findById(idCategoria);
        if (!optionalCategoria.isPresent()) {
            throw new ExceptionModel("Categoria "+idCategoria+" não encontrada");
        }
        return optionalCategoria.get();
    }
}
