package br.fema.edu.spring.categoria.resource;

import br.fema.edu.spring.categoria.dto.*;
import br.fema.edu.spring.categoria.form.*;
import br.fema.edu.spring.categoria.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/categorias")
@RestController
public class CategoriaResource {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        return this.categoriaService.listarCategorias();
    }

    @GetMapping("/{idCategoria}")
        public ResponseEntity<CategoriaDTO> listarCategoriaPorId(@PathVariable Long idCategoria){
        return this.categoriaService.buscarCategoriasPorId(idCategoria);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> cadastrarNovaCategoria(@RequestBody CategoriaFORM formulario){
        return this.categoriaService.cadastrarNovaCategoria(formulario);
    }

    @PutMapping("/{idCategoria}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long idCategoria, @RequestBody CategoriaFORM formulario){
        return this.categoriaService.atualizarCategoria(idCategoria, formulario);
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<CategoriaDTO> deletarCategoria(@PathVariable Long idCategoria){
        return this.categoriaService.deletarCategoria(idCategoria);
    }

    @DeleteMapping("/deletar-produtos-categoria/{idCategoria}")
    public ResponseEntity<CategoriaDTO> deletarElementosPeloURL(@PathVariable Long idCategoria){
        return this.categoriaService.deletarElementosPeloURL(idCategoria);
    }
}
