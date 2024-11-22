package com.br.teste.bookstore.mapper;

import com.br.teste.bookstore.api.request.BookParcialUpdateRequestDTO;
import com.br.teste.bookstore.api.request.BookRequestDTO;
import com.br.teste.bookstore.api.response.BookResponseDTO;
import com.br.teste.bookstore.entity.BookEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookMapper {

    public BookEntity toEntity(final BookRequestDTO livro) {

        final String autor = livro.getAutor();
        final String titulo = livro.getTitulo();
        final String isbn = livro.getIsbn();
        final String descricao = livro.getDescricao();
        final LocalDate dataLancamento = livro.getDataLancamento();

        return BookEntity.builder()
                .autor(autor)
                .titulo(titulo)
                .isbn(isbn)
                .descricao(descricao)
                .dataLancamento(dataLancamento)
                .build();
    }

    public BookEntity toEntityToUpdate(final Long livroId, final BookRequestDTO livro) {

        final String autor = livro.getAutor();
        final String titulo = livro.getTitulo();
        final String isbn = livro.getIsbn();
        final String descricao = livro.getDescricao();
        final LocalDate dataLancamento = livro.getDataLancamento();

        return BookEntity.builder()
                .id(livroId)
                .autor(autor)
                .titulo(titulo)
                .isbn(isbn)
                .descricao(descricao)
                .dataLancamento(dataLancamento)
                .build();

    }

    public BookEntity toEntityToParcialUpdate(final BookEntity entity, final BookParcialUpdateRequestDTO requestDTO) {

        final Long id = entity.getId();
        final String autor = requestDTO.getAutor();
        final String titulo = requestDTO.getTitulo();
        final String isbn = requestDTO.getIsbn();
        final String descricao = requestDTO.getDescricao();
        final LocalDate dataLancamento = requestDTO.getDataLancamento();

        return BookEntity.builder()
                .id(id)
                .autor(StringUtils.isNotBlank(autor) ? autor : entity.getAutor())
                .titulo(StringUtils.isNotBlank(titulo) ? titulo : entity.getTitulo())
                .isbn(StringUtils.isNotBlank(isbn) ? isbn : entity.getIsbn())
                .descricao(StringUtils.isNotBlank(descricao) ? descricao : entity.getDescricao())
                .dataLancamento(dataLancamento != null ? dataLancamento : entity.getDataLancamento())
                .build();

    }



    public BookResponseDTO toDto(BookEntity livro) {

        final Long id = livro.getId();
        final String autor = livro.getAutor();
        final String titulo = livro.getTitulo();
        final String isbn = livro.getIsbn();
        final String descricao = livro.getDescricao();
        final LocalDate dataLancamento = livro.getDataLancamento();

        return BookResponseDTO.builder()
                .id(id)
                .autor(autor)
                .titulo(titulo)
                .isbn(isbn)
                .descricao(descricao)
                .dataLancamento(dataLancamento)
                .build();
    }

}
