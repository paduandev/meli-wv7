package br.com.dh.testes03.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandleContaException {

    @ExceptionHandler(ContaInexistenteException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(ContaInexistenteException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Objeto não encontrado")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientSaldoException.class)
    public ResponseEntity<ExceptionDetails> handlerInsufficientSaldoException(InsufficientSaldoException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Saldo insuficiente")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }
}
