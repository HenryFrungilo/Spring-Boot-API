package br.fema.edu.spring.cliente.form;

import br.fema.edu.spring.cliente.model.Cliente;

public class
ClienteForm {


    private String nome;

    private String cpf;

    private String rg;

    public Cliente converter(Cliente cliente){
        cliente.setCpf(this.cpf);
        cliente.setRg(this.rg);
        cliente.setNome(this.nome);
        return cliente;
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
}
