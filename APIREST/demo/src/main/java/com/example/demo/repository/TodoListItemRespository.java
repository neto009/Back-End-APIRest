package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.TodoList;
import com.example.demo.domain.TodoListItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListItemRespository extends CrudRepository<TodoListItem, Integer> {

    List<TodoListItem> findByTodoList(TodoList todolist);
    
}
