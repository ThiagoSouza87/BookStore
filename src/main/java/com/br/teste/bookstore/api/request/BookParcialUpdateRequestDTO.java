package com.br.teste.bookstore.api.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookParcialUpdateRequestDTO {

    private String titulo;
    private String descricao;
    private String autor;
    private LocalDate dataLancamento;
    private String isbn;
}
