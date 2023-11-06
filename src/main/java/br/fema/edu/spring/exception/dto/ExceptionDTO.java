package br.fema.edu.spring.exception.dto;

import java.io.Serial;
import java.io.Serializable;

public class ExceptionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
   public String mensagem;

   public ExceptionDTO(String campo){
        this.mensagem = mensagem;
   }
    public String getMensagem(){
       return mensagem;
   }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
