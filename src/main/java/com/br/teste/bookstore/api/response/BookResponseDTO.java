package com.br.teste.bookstore.api.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class BookResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String autor;
    private LocalDate dataLancamento;
    private String isbn;
}
