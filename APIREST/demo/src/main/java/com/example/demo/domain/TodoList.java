package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;


@Data 
@NoArgsConstructor
@Entity
public class TodoList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "todoList")
    @JsonManagedReference
    private List<TodoListItem> todolistitem = new ArrayList<TodoListItem>();

    public TodoList(Object object, String string) {
    }

}
