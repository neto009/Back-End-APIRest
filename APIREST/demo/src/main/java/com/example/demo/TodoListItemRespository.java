package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface TodoListItemRespository extends CrudRepository<TodoListItem, Integer> {
    
}
