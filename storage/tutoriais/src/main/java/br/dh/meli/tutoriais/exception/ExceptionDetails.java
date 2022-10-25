package br.dh.meli.tutoriais.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ExceptionDetails {
    private String title;
    private String message;
    private LocalDateTime timestamp;
}
