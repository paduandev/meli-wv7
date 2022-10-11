package br.com.dh.testes03.exception;

public class ContaInexistenteException extends  Exception {
    public ContaInexistenteException(String message) {
        super(message);
    }
}
