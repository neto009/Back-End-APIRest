package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.TodoList;
import com.example.demo.repository.TodoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TodoListService {
    
    @Autowired
    TodoListRepository repository;

    public List<TodoList> todos() {
        return (List<TodoList>) repository.findAll();
    }

    public TodoList novo(TodoList todolist) {
        return repository.save(todolist);
    }

    public Optional<TodoList> busca(Integer id) {
        return repository.findById(id);
    }

    public TodoList atualiza(TodoList todolist, Integer id) {

        if(repository.existsById(id)){
        todolist.setId(id);
        return repository.save(todolist);
        }

        throw new TodoListNaoEncontradoException(id);
    }

    public void exclui(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
