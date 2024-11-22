package com.br.teste.livraria;

import com.br.teste.bookstore.api.request.BookRequestDTO;
import com.br.teste.bookstore.api.response.BookResponseDTO;

import com.br.teste.bookstore.service.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTeste {

    @Autowired
    private BookServiceImpl bookService;

    @Test
    public void deveSalvarLivro() {
        // given
        BookRequestDTO livro = build();

        // when
        bookService.save(livro);

        // then
        List<BookResponseDTO> listar = bookService.findAll();
        assertTrue(listar.stream().filter(bookResponseDTO -> bookResponseDTO.getIsbn().equals(livro.getIsbn())).count() > 0);
    }

    @Before
    public void setupListar() {
        BookRequestDTO livro = build();
        bookService.save(livro);
    }

    @Test
    public void deveListar() {
        List<BookResponseDTO> listar = bookService.findAll();
        assertNotNull(listar);
        assertTrue(listar.size() > 0);
    }

    @Before
    public void setupUpdate() {
        BookRequestDTO livro = build();
        bookService.save(livro);
    }

    @Test
    public void deveAlterarLivro() {

        BookRequestDTO bookRequestDTO = bookService.findAll().stream().map(livro ->
                BookRequestDTO.builder()
                        .id(livro.getId())
                        .isbn(livro.getIsbn())
                        .titulo("titulo atualizado")
                        .autor(livro.getAutor())
                        .dataLancamento(livro.getDataLancamento())
                        .descricao(livro.getDescricao())
                        .build()
        ).findAny().orElse(null);
        Long id = bookRequestDTO.getId();

        bookService.update(bookRequestDTO.getId(), bookRequestDTO);
        BookResponseDTO bookResponseDTO = bookService.findById(id);
        assertNotNull(bookResponseDTO);
        assertTrue(bookResponseDTO.getTitulo().equals("titulo atualizado"));

    }

    private BookRequestDTO build() {
        return BookRequestDTO.builder()
                .isbn("123-456")
                .descricao("descricao-tomate")
                .dataLancamento(LocalDate.now())
                .autor("autor-tomate")
                .titulo("titulo-tomate")
                .build();
    }

    @Before
    public void setupDelete() {
        BookRequestDTO livro = build();
        bookService.save(livro);
    }

    @Test
    public void deveDeletar() {

        bookService.findAll().forEach(livro -> {
            bookService.deleteById(livro.getId());});
        List<BookResponseDTO> listar = bookService.findAll();
        assertNotNull(listar);
        assertTrue(listar.size() == 0);
    }
}
