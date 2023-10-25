package br.fema.edu.spring.produto.repository;

import br.fema.edu.spring.produto.model.*;
import org.springframework.data.jpa.repository.*;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
