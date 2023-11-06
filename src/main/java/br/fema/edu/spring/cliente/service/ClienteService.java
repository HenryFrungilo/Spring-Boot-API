package br.fema.edu.spring.cliente.service;

import br.fema.edu.spring.categoria.dto.*;
import br.fema.edu.spring.categoria.form.*;
import br.fema.edu.spring.categoria.model.*;
import br.fema.edu.spring.categoria.repository.*;
import br.fema.edu.spring.cliente.dto.ClienteDTO;
import br.fema.edu.spring.cliente.form.ClienteForm;
import br.fema.edu.spring.cliente.model.Cliente;
import br.fema.edu.spring.cliente.repository.ClienteRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        List<Cliente> clientes = this.clienteRepository.findAll();
        return ResponseEntity.ok(ClienteDTO.converter(clientes));
    }

    @GetMapping
    public ResponseEntity<ClienteDTO> buscarClientesPorId(Long idCliente){
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(idCliente);
        if(!optionalCliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = optionalCliente.get();
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarClientePorLetraInicialDoNome(String letraDoNome){
        List<Cliente> clientes = this.clienteRepository.findByNomeStartingWithIgnoreCaseOrderByNome(letraDoNome);
        return ResponseEntity.ok(ClienteDTO.converter(clientes));
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarNovoCliente (ClienteForm formulario){
        Cliente cliente = new Cliente();
        cliente.setNome(formulario.getNome());
        cliente.setRg(formulario.getRg());
        cliente.setCpf(formulario.getCpf());
        cliente = clienteRepository.save(cliente);
        new ClienteDTO(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ClienteDTO> atualizarCliente(Long idCliente, ClienteForm formulario) {
        Cliente cliente = this.buscarCliente(idCliente);
        cliente.setNome(formulario.getNome());
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<ClienteDTO> deletarCliente(Long idCliente) {
        Cliente cliente = this.buscarCliente(idCliente);
        this.clienteRepository.deleteById(cliente.getId());
        return ResponseEntity.ok().build();
    }


    public Cliente buscarCliente(Long idCliente) {
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(idCliente);
        if (!optionalCliente.isPresent()) {
            return null;
        }
        return optionalCliente.get();
    }
}
