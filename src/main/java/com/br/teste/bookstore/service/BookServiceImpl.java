package com.br.teste.bookstore.service;

import com.br.teste.bookstore.api.request.BookParcialUpdateRequestDTO;
import com.br.teste.bookstore.api.request.BookRequestDTO;
import com.br.teste.bookstore.api.response.BookResponseDTO;
import com.br.teste.bookstore.exception.NotFoundException;
import com.br.teste.bookstore.mapper.BookMapper;
import com.br.teste.bookstore.entity.BookEntity;
import com.br.teste.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements  BookService{

    @Autowired
    private BookMapper mapper;

    @Autowired
    private BookRepository repository;

    public List<BookResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public BookResponseDTO findById(final Long livroId) {
        final Optional<BookEntity> livroOptional = repository.findById(livroId);
        return livroOptional.map(mapper::toDto).orElseThrow(NotFoundException::new);
    }


    public void save(final BookRequestDTO livro) {
        repository.save(mapper.toEntity(livro));
    }


    public void update(final Long livroId, final BookRequestDTO requestDTO) {
        final BookEntity livro = mapper.toEntityToUpdate(livroId, requestDTO);
        repository.save(livro);
    }

    public void updatePatch(final Long livroId, final BookParcialUpdateRequestDTO requestDTO) {

        final BookEntity entity = repository.findById(livroId).orElseThrow(NotFoundException::new);
        final BookEntity livro = mapper.toEntityToParcialUpdate(entity, requestDTO);

        repository.save(livro);
    }


    public void deleteById(final Long livroId) {
        repository.deleteById(livroId);
    }
}
