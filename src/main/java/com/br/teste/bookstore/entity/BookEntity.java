package com.br.teste.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_livros")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_livro")
    private Long id;

    @Column(name = "des_titulo")
    private String titulo;

    @Column(name = "des_descricao")
    private String descricao;

    @Column(name = "des_autor")
    private String autor;

    @Column(name = "dat_lancamento")
    private LocalDate dataLancamento;

    @Column(name = "cod_isbn")
    private String isbn;



}
