package br.fema.edu.spring.produto.resource;

import br.fema.edu.spring.categoria.dto.*;
import br.fema.edu.spring.categoria.service.*;
import br.fema.edu.spring.produto.dto.*;
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
}
