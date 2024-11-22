package com.br.teste.bookstore.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class BookRequestDTO {

    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private String autor;
    @NotNull
    private LocalDate dataLancamento;
    @NotBlank
    private String isbn;
}
