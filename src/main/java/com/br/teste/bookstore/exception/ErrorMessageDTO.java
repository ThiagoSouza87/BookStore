package com.br.teste.bookstore.exception;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorMessageDTO {
    private String message;
}
