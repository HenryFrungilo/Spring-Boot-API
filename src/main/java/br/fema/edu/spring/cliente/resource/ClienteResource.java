package br.fema.edu.spring.cliente.resource;

import br.fema.edu.spring.cliente.dto.ClienteDTO;
import br.fema.edu.spring.cliente.form.ClienteForm;
import br.fema.edu.spring.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ClienteResource {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return this.clienteService.listarClientes();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> listarClientePorId(@PathVariable Long idCliente){
        return this.clienteService.buscarClientesPorId(idCliente);
    }

    @GetMapping("/buscarPorInicial/{letraDoNome}")
    public ResponseEntity<List<ClienteDTO>> buscarClientePorLetraInicialDoNome(@PathVariable String letraDoNome){
        return this.clienteService.buscarClientePorLetraInicialDoNome(letraDoNome);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarNovoCliente(@RequestBody ClienteForm formulario){
        return this.clienteService.cadastrarNovoCliente(formulario);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteForm formulario){
        return this.clienteService.atualizarCliente(idCliente, formulario);
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> deletarCliente(@PathVariable Long idCliente){
        return this.clienteService.deletarCliente(idCliente);
    }
}
