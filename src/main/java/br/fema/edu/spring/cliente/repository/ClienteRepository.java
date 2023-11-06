package br.fema.edu.spring.cliente.repository;

import br.fema.edu.spring.cliente.dto.ClienteDTO;
import br.fema.edu.spring.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeStartingWithIgnoreCaseOrderByNome(String LetraDoNome);
}
