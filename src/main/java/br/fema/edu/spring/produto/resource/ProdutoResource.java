package br.fema.edu.spring.produto.resource;

import br.fema.edu.spring.categoria.dto.*;
import br.fema.edu.spring.categoria.form.CategoriaFORM;
import br.fema.edu.spring.categoria.service.*;
import br.fema.edu.spring.produto.dto.*;
import br.fema.edu.spring.produto.form.ProdutoForm;
import br.fema.edu.spring.produto.model.Produto;
import br.fema.edu.spring.produto.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/produtos")
@RestController
public class ProdutoResource {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        return this.produtoService.listarProdutos();
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> listarProdutosPorId(@PathVariable Long idProduto){
        return this.produtoService.listarProdutosPorId(idProduto);
    }
    @PostMapping
    public ResponseEntity<ProdutoDTO> listarProdutosPorId(@RequestBody ProdutoForm formulario){
        return this.produtoService.cadastrarProduto(formulario);
    }


    @PutMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long idProduto, @RequestBody ProdutoForm formulario){
        return this.produtoService.atualizarProduto(idProduto, formulario);

    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> deletarCategoria(@PathVariable Long idProduto){
        return this.produtoService.deletarProduto(idProduto);
    }
}
