package com.example.demo.controller;

import java.util.List;

import com.example.demo.domain.TodoList;
import com.example.demo.service.TodoListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todolist")
public class TodoListController {
    
    @Autowired
    private TodoListService service;
    private Object HttpStatus;

    @GetMapping
    public ResponseEntity<List<TodoList>> recuperaTodosRegistros() {
        return ResponseEntity.status(HttpStatus.OK).body(service.todos());
    }

    @PostMapping
    public ResponseEntity<TodoList> criaNovoRegistro(@RequestBody TodoList todolist) {
        return ResponseEntity.status(HttpStatus.OK).body(service.novo(todolist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> buscaUmRegistro(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.busca(id).orElseThrow(() -> new PessoaNaoEncontradaException(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoList> atualizaRegistro(@RequestBody TodoList todolist, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualiza(todolist, id));
    }


    @DeleteMapping("/{id}")
    public void excluiRegistro(@PathVariable Integer id) {
        service.exclui(id);
    }
}
