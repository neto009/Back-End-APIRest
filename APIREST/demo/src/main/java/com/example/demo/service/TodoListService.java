package com.example.demo.service;

import java.util.List;
import java.util.Optional;

//import com.example.demo.controller.TodoListNaoEncontradoException;
import com.example.demo.domain.TodoList;
import com.example.demo.repository.TodoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TodoListService {
    
    @Autowired
    private TodoListRepository repository;

    public List<TodoList> GetAll() {
        return repository.findAll();
    }

    public TodoList create(TodoList todoList) {
        return repository.save(todoList);
    }

    public Optional<TodoList> GetById(Integer id) {
        return repository.findById(id);
    }

    public TodoList update(TodoList todoList, Integer id) {

        if(repository.existsById(id)){
            todoList.setId(id);
            return repository.save(todoList);
        }

        return null;
    }

    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
