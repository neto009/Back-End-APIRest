package com.example.demo.controller;

import org.springframework.web.HttpMediaTypeNotSupportedException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestControllerAdvice
public class TodoListNaoEncontradaAdvice {
        @ResponseBody
        @ExceptionHandler
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String peopleNotFoundHandler(TodoListNaoEncontradoException ex) {
                return ex.getMessage();
        }

        @ExceptionHandler
        public ResponseEntity<String> deleteError(EmptyResultDataAccessException ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
        }

        @ExceptionHandler
        public ResponseEntity<String> createFormatError(HttpMediaTypeNotSupportedException ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formato de aquivo invalido!");
        }
}
