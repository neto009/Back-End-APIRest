package com.example.demo.repository;

import com.example.demo.domain.TodoListItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListItemRespository extends CrudRepository<TodoListItem, Integer> {
    
}
