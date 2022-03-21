package com.example.demo.repository;

import com.example.demo.domain.TodoList;

import org.springframework.data.repository.CrudRepository;


public interface TodoListRepository extends CrudRepository<TodoList, Integer> {
    
}
