package br.fema.edu.spring.categoria.repository;

import br.fema.edu.spring.categoria.model.*;
import org.springframework.data.jpa.repository.*;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
