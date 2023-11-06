package br.fema.edu.spring.produto.repository;

import br.fema.edu.spring.produto.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByCategoria_Id(Long idCategoria);
    void deleteByCategoria_Id(Long idCategoria);
}
