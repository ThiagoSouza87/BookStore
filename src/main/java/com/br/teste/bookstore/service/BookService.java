package com.br.teste.bookstore.service;

import com.br.teste.bookstore.api.request.BookParcialUpdateRequestDTO;
import com.br.teste.bookstore.api.request.BookRequestDTO;
import com.br.teste.bookstore.api.response.BookResponseDTO;

import java.util.List;

public interface BookService {

    public List<BookResponseDTO> findAll();

    public BookResponseDTO findById(final Long livroId);

    public void save(final BookRequestDTO livro);

    public void update(final Long livroId, final BookRequestDTO requestDTO);

    public void updatePatch(final Long livroId, final BookParcialUpdateRequestDTO requestDTO);

    public void deleteById(final Long livroId);

}
