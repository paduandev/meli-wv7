package br.com.dh.testes02.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.WebHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders httpHeaders,
            HttpStatus httpStatus,
            WebRequest webRequest) {

        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Parâmetros inválidos")
                        .message("Os campos estão inválidos")
                        .fields(errors.stream().map(FieldError::getField)
                                .collect(Collectors.joining(";")))
                        .fieldsMessages(errors.stream().map(FieldError::getDefaultMessage)
                                .collect(Collectors.joining(";")))
                        .timestamp(LocalDateTime.now())
                        .build() //new
                ,
                httpStatus);

    }
}
