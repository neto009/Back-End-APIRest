package com.example.demo.controller;

public class TodoListNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TodoListNaoEncontradoException(Integer id) {
        super("Não encontrei o usuário " + id);
    }
}
