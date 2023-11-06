package br.fema.edu.spring.cliente.dto;

import br.fema.edu.spring.cliente.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;

    private String rg;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.rg = cliente.getRg();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public static List<ClienteDTO> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
