package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.TodoList;
import com.example.demo.service.TodoListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todolist")
public class TodoListController {
    
    @Autowired
    private TodoListService service;

    @GetMapping
    public ResponseEntity<List<TodoList>> GetAll() {

        try{

            List<TodoList> items = service.GetAll();

            if(items.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            return ResponseEntity.status(HttpStatus.OK).body(items);

        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping
    public ResponseEntity<TodoList> create(@RequestBody TodoList todolist) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(todolist));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoList> getById(@PathVariable Integer id) {
        Optional<TodoList> existingItemOptional = service.GetById(id);

        if(existingItemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(existingItemOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoList> update(@RequestBody TodoList item, @PathVariable Integer id) {

        TodoList todoList = service.update(item, id);

        if(todoList != null){
            return ResponseEntity.status(HttpStatus.OK).body(service.update(item, id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {

        try {
            service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID não encontrado", e);
        }
    }
}
