package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.TodoList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Integer> {

    @Override
    public List<TodoList> findAll();
}
