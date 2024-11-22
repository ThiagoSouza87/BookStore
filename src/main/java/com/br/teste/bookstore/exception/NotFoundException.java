package com.br.teste.bookstore.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Não foi encontrado registro(s) com o(s) parâmetro(s) informado.");
    }
}
