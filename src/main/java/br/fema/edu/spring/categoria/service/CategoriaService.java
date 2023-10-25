package br.fema.edu.spring.categoria.service;

import br.fema.edu.spring.categoria.dto.*;
import br.fema.edu.spring.categoria.form.*;
import br.fema.edu.spring.categoria.model.*;
import br.fema.edu.spring.categoria.repository.*;
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


    public Categoria buscarCategoria(Long idCategoria) {
        Optional<Categoria> optionalCategoria = this.categoriaRepository.findById(idCategoria);
        if (!optionalCategoria.isPresent()) {
            return null;
        }
        return optionalCategoria.get();
    }
}
