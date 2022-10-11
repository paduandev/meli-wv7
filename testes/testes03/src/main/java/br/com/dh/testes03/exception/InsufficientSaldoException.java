package br.com.dh.testes03.exception;

public class InsufficientSaldoException extends Exception {
    public InsufficientSaldoException(String message) {
        super(message);
    }
}
