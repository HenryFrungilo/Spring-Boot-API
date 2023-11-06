package br.fema.edu.spring.categoria.repository;

import br.fema.edu.spring.categoria.model.*;
import br.fema.edu.spring.produto.model.Produto;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
