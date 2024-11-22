package com.br.teste.bookstore.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionManagerResponse {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessageDTO> manageMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(ErrorMessageDTO.builder()
                .message("Existem parâmetro(s) obritório(s) não informado(s).")
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity manageNotFoundException(NotFoundException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDTO> manageException(Exception exception) {
        return ResponseEntity.internalServerError().body(ErrorMessageDTO.builder()
                .message("Ocorreu um erro inesperado!")
                .build());
    }
}
