package br.dh.meli.tutoriais.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TutorialExceptionHandler {

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ExceptionDetails> handlerInvalidParamException(InvalidParamException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Parâmetro inválido")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

}
