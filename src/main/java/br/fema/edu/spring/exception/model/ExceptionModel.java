package br.fema.edu.spring.exception.model;

public class ExceptionModel extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExceptionModel(String mensagem){
        super(mensagem);
    }
}
